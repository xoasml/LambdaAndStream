package streamTheory.loop2;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex16_FinalGroupingBy {
    public static void main(String[] args) {
        Student[] stuArr = {
                new Student("나자바", true, 1, 1, 300),
                new Student("김지미", false, 1, 1, 250),
                new Student("김자바", true, 1, 1, 200),
                new Student("이지미", false, 1, 2, 150),
                new Student("남자바", true, 1, 2, 100),
                new Student("안지미", false, 1, 2, 50),
                new Student("황지미", false, 1, 3, 100),
                new Student("강지미", false, 1, 3, 150),
                new Student("이자바", true, 1, 3, 200),

                new Student("나자바", true, 2, 1, 300),
                new Student("김지미", false, 2, 1, 250),
                new Student("김자바", true, 2, 1, 200),
                new Student("이지미", false, 2, 2, 150),
                new Student("남자바", true, 2, 2, 100),
                new Student("안지미", false, 2, 2, 50),
                new Student("황지미", false, 2, 3, 100),
                new Student("강지미", false, 2, 3, 150),
                new Student("이자바", true, 2, 3, 200)
        };

        System.out.println("1. 단순그룹화(반별로 그룹화)");
        Map<Integer, List<Student>> stuByBan = Stream.of(stuArr).collect(Collectors.groupingBy(Student::getBan));
        System.out.println(stuByBan);

        System.out.println("\n2. 단순그룹화(성적별로 그룹화)");
        Map<Student.Level, List<Student>> stuByScore = Stream.of(stuArr).collect(
                Collectors.groupingBy(student -> {
                    if (student.getScore() >= 200) {
                        return Student.Level.HIGH;
                    } else if (student.getScore() >= 100) {
                        return Student.Level.MID;
                    } else {
                        return Student.Level.LOW;
                    }
                })
        );
        System.out.println(stuByScore.get(Student.Level.HIGH));
        System.out.println(stuByScore.get(Student.Level.MID));
        System.out.println(stuByScore.get(Student.Level.LOW));

        System.out.println("\n3. 단순그룹화 + 통계(성적별 학생수)");
        Map<Student.Level, Long> cntByScore = Stream.of(stuArr).collect(
                Collectors.groupingBy(
                        student -> {
                            if (student.getScore() >= 200) {
                                return Student.Level.HIGH;
                            } else if (student.getScore() >= 100) {
                                return Student.Level.MID;
                            } else {
                                return Student.Level.LOW;
                            }
                        }
                        , Collectors.counting()
                )
        );

        System.out.println("\n4. 다중그룹화(학년별, 반별)");
        Map<Integer, Map<Integer, List<Student>>> stuByHakBan = Stream.of(stuArr).collect(
                Collectors.groupingBy(Student::getHak
                        , Collectors.groupingBy(Student::getBan))
        );

        System.out.println(stuByHakBan);

        System.out.println("\n5. 다중그룹화 + 통계(학년별, 반별 1등)");
        Map<Integer, Map<Integer, Student>> topByHakBan = Stream.of(stuArr)
                .collect(
                        Collectors.groupingBy(
                                Student::getHak
                                , Collectors.groupingBy(
                                        Student::getBan
                                        , Collectors.collectingAndThen(
                                                Collectors.maxBy(Comparator.comparing(Student::getScore))
                                                , Optional::get
                                        )
                                )
                        )
                );

        System.out.println(topByHakBan);

        System.out.println("\n6. 다중그룹화 + 통계(학년별, 반별 성적그룹)");
        Map<String, Set<Student.Level>> groupByHakBan = Stream.of(stuArr)
                .collect(
                        Collectors.groupingBy(
                                s -> s.getHak() + "-" + s.getBan()
                                , Collectors.mapping(
                                        s -> {
                                            if (s.getScore() >= 200) {
                                                return Student.Level.HIGH;
                                            } else if (s.getScore() >= 100) {
                                                return Student.Level.MID;
                                            } else {
                                                return Student.Level.LOW;
                                            }
                                        }, Collectors.toSet()
                                )
                        )
                );
        groupByHakBan.forEach((k, v) -> {
            System.out.println("[" + k + "]" + v);
        });
    }
}
