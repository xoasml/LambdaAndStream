package streamTheory.practice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Student2 {
    String name;
    boolean isMale; // 성별
    int hak;        // 학년
    int ban;        // 반
    int score;

    public Student2(String name, boolean isMale, int hak, int ban, int score) {
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public boolean isMale() {
        return isMale;
    }

    public int getHak() {
        return hak;
    }

    public int getBan() {
        return ban;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "[" + name +
                ", " + (isMale == true ? "남" : "여") +
                ", " + hak + "학년" +
                ", " + ban + "반" +
                ", " + score + "점" +
                ']';
    }

    // gorupingBy()에서 사용
    enum Level {HIGH, MID, LOW} // 성적을 상, 중, 하, 세 단계로 분류
}

public class Ex15_FinalPartitioningBy {
    public static void main(String[] args) {
        Student2[] stuArr = {
                new Student2("나자바", true, 1, 1, 300),
                new Student2("김지미", false, 1, 1, 250),
                new Student2("김자바", true, 1, 1, 200),
                new Student2("이지미", false, 1, 2, 150),
                new Student2("남자바", true, 1, 2, 100),
                new Student2("안지미", false, 1, 2, 50),
                new Student2("황지미", false, 1, 3, 100),
                new Student2("강지미", false, 1, 3, 150),
                new Student2("이자바", true, 1, 3, 200),

                new Student2("나자바", true, 2, 1, 300),
                new Student2("김지미", false, 2, 1, 250),
                new Student2("김자바", true, 2, 1, 200),
                new Student2("이지미", false, 2, 2, 150),
                new Student2("남자바", true, 2, 2, 100),
                new Student2("안지미", false, 2, 2, 50),
                new Student2("황지미", false, 2, 3, 100),
                new Student2("강지미", false, 2, 3, 150),
                new Student2("이자바", true, 2, 3, 200)
        };

        System.out.println("1. 단순분할(성별로 분할)");
        Map<Boolean, List<Student2>> stuBySex = Stream.of(stuArr)
                .collect(Collectors.partitioningBy(Student2::isMale));

        List<Student2> maleStudent   = stuBySex.get(true);
        List<Student2> femaleStudent = stuBySex.get(false);

        for (Student2 s: maleStudent) System.out.println(s);
        for (Student2 s: femaleStudent) System.out.println(s);

        System.out.println("\n2. 단순분할 + 통계(성별 학생수)");
        Map<Boolean, Long> stuNumBySex = Stream.of(stuArr)
                .collect(Collectors.partitioningBy(Student2::isMale, Collectors.counting()));

        System.out.println("남학생 수 :" + stuNumBySex.get(true));
        System.out.println("여학생 수 :" + stuNumBySex.get(false));

        System.out.println("\n3. 단순분할 + 통계(성별 1등)");
        Map<Boolean, Optional<Student2>> topScoreBySexOpt = Stream.of(stuArr)
                .collect(Collectors.partitioningBy(Student2::isMale,
//                        Collectors.maxBy((o1, o2) -> o1.getScore() - o2.getScore())
                        Collectors.maxBy(Comparator.comparingInt(Student2::getScore))
                ));

        System.out.println(topScoreBySexOpt.get(true));
        System.out.println(topScoreBySexOpt.get(false));

        Map<Boolean, Student2> topScoreBySex = Stream.of(stuArr)
                .collect(Collectors.partitioningBy(Student2::isMale,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Student2::getScore)), Optional::get
                        )
                ));


        System.out.println("\n 다중분할(성별 불합격자, 100점 이하)");
        Map<Boolean, Map<Boolean, List<Student2>>> failStuBySex = Stream.of(stuArr)
                .collect(Collectors.partitioningBy(Student2::isMale,
                        Collectors.partitioningBy(s -> s.getScore() <= 100)));

        List<Student2> failedMaleStu   = failStuBySex.get(true).get(true);
        List<Student2> failedFemaleStu = failStuBySex.get(false).get(true);

        // list.stream 을 더 많이 씀
        failedMaleStu.forEach(System.out::println);
        failedFemaleStu.forEach(System.out::println);
    }
}
