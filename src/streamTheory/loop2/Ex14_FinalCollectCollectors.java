package streamTheory.loop2;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex14_FinalCollectCollectors {
    public static void main(String[] args) {
        MiddleStu[] stuArr = {
                new MiddleStu("이자바", 3, 300),
                new MiddleStu("김자바", 1, 200),
                new MiddleStu("안자바", 2, 100),
                new MiddleStu("박자바", 2, 150),
                new MiddleStu("소자바", 1, 200),
                new MiddleStu("나자바", 3, 290),
                new MiddleStu("감자바", 3, 180)
        };

        // 학생 이름만 뽑아서 List<String>에 저장
        List<String> name = Stream.of(stuArr).map(MiddleStu::getName).collect(Collectors.toList());
        System.out.println(name);

//        MiddleStu[] miArr = Stream.of(stuArr).toArray(value -> new MiddleStu[value]);
        MiddleStu[] miArr = Stream.of(stuArr).toArray(MiddleStu[]::new);
        System.out.println(Arrays.toString(miArr));

        // 스트림을 Map<String, Student>로 변환, 학생 이름이 Key
        Map<String, MiddleStu> stuMap = Stream.of(stuArr)
                .collect(Collectors.toMap(MiddleStu::getName, middleStu -> middleStu)); // toMap(Key 입력, value 입력)

        // 전체 통계 - 갯수, 총합
        long count = Stream.of(stuArr).collect(Collectors.counting()); // count
        long totlaScore = Stream.of(stuArr).collect(Collectors.summingLong(MiddleStu::getTotalScore)); // sum

        System.out.println(count);
        System.out.println(totlaScore);

        // Collectors.reducing으로 토탈 스코어 뽑기
        totlaScore = Stream.of(stuArr).collect(Collectors.reducing(0, MiddleStu::getTotalScore, Integer::sum));
        System.out.println(totlaScore);

        // 최고 점수 뽑기
//        Optional<MiddleStu> topScore = Stream.of(stuArr).max((o1, o2) -> o1.totalScore - o2.totalScore);
//        Optional<MiddleStu> topScore = Stream.of(stuArr).max(Comparator.comparing(MiddleStu::getTotalScore));
        Optional<MiddleStu> topScore = Stream.of(stuArr).collect(Collectors.maxBy(Comparator.comparing(MiddleStu::getTotalScore)));
        System.out.println(topScore);

        // 통계 모음
        IntSummaryStatistics stat = Stream.of(stuArr).collect(Collectors.summarizingInt(MiddleStu::getTotalScore));
        System.out.println(stat);
        System.out.println(stat.getMax());

        // 이름 문자열로 합치기
        String stuNames = Stream.of(stuArr).map(MiddleStu::getName).collect(Collectors.joining(", ", "[", "]"));
        System.out.println(stuNames);
    }
}
