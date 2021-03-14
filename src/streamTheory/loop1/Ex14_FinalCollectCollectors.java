package streamTheory.loop1;

// reduce(identity(초기값), accumulator 누적 수행 작업) : 리듀싱 - 전체에 대한
// collect(Collector 인터페이스) : 그룹별 리듀싱 - 그룹별로 나누어서
// collect : 최종연산
// Collector : 인터페이스
// Collectors : 클래스 (Collector를 구현한 구현체를 가지고 있는 클래스)

// 스트림을 컬렉션 변환
// - toList(), toSet(), toMap(), toCollection();

// 스트림을 배열로 변환
// - toArray()

// 스트림의 통계 - 그룹별로 통계 내는게 가능함, 그냥 통계는 전체 통계만 가능함
// - counting(), summingInt(), maxBy(), minBy(), ...

// 스트림을 리듀싱
// - reducing() - Collectors의 reduce로 그룹별 리듀싱이 가능하다

// 문자열 스트림의 요소를 모두 연결
// - joining()

// 스트림의 그룹화와 분할
// - partitioningBy() - 스트림을 2분할 한다.
// - groupingBy() - 스트림을 n분할 한다.

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex14_FinalCollectCollectors {
    public static void main(String[] args) {
        Student1[] stuArr = {
                new Student1("이자바", 3, 300),
                new Student1("김자바", 1, 200),
                new Student1("안자바", 2, 100),
                new Student1("박자바", 2, 150),
                new Student1("소자바", 1, 200),
                new Student1("나자바", 3, 290),
                new Student1("감자바", 3, 180)
        };

        // 학생 이름만 뽑아서 List<String>에 저장
        List<String> name = Stream.of(stuArr).map(Student1::getName).collect(Collectors.toList());
        System.out.println(name);

        Student1[] reArr = Stream.of(stuArr).toArray(Student1[]::new);
        System.out.println(Arrays.toString(reArr));

        // 스트림을 Map<String, Student>로 변환, 학생 이름이 key
        Map<String, Student1> stuMap = Stream.of(stuArr).collect(Collectors.toMap(Student1::getName, student1 -> student1));
        System.out.println("Map = " + stuMap);

        // 전체통계 - 갯수, 총합
        long count = Stream.of(stuArr).collect(Collectors.counting()); // count
        long totalScore = Stream.of(stuArr).collect(Collectors.summingInt(Student1::getTotalScore));

        System.out.println(count);
        System.out.println(totalScore);

        // Collectors.reducing으로 토탈 스코어 뽑기
        totalScore = Stream.of(stuArr).collect(Collectors.reducing(0, Student1::getTotalScore, Integer::sum));
        System.out.println(totalScore);

        // 최고 점수 뽑기
        Optional<Student1> topStudent = Stream.of(stuArr).collect(Collectors.maxBy(Comparator.comparing(Student1::getTotalScore)));
        System.out.println(topStudent.get());

        // 통계 모음
        IntSummaryStatistics stat = Stream.of(stuArr).collect(Collectors.summarizingInt(Student1::getTotalScore));
        System.out.println(stat);
        
        // 이름 문자열로 합치기
        String stuNames = Stream.of(stuArr).map(Student1::getName).collect(Collectors.joining(",","[","]"));
        System.out.println(stuNames);

    }
}

class Student1 implements Comparable<Student> {
    String name;
    int ban;
    int totalScore;

    public Student1(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", ban=" + ban +
                ", totalScore=" + totalScore +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getBan() {
        return ban;
    }

    public int getTotalScore() {
        return totalScore;
    }

    @Override
    public int compareTo(Student o) {
        return o.totalScore - this.totalScore;
    }
}
