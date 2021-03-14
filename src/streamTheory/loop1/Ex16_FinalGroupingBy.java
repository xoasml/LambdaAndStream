package streamTheory.loop1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Student3 {
    String name;
    boolean isMale; // 성별
    int hak;        // 학년
    int ban;        // 반
    int score;

    public Student3(String name, boolean isMale, int hak, int ban, int score) {
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

public class Ex16_FinalGroupingBy {
    public static void main(String[] args) {
        Student3[] stuArr = {
                new Student3("나자바", true, 1, 1, 300),
                new Student3("김지미", false, 1, 1, 250),
                new Student3("김자바", true, 1, 1, 200),
                new Student3("이지미", false, 1, 2, 150),
                new Student3("남자바", true, 1, 2, 100),
                new Student3("안지미", false, 1, 2, 50),
                new Student3("황지미", false, 1, 3, 100),
                new Student3("강지미", false, 1, 3, 150),
                new Student3("이자바", true, 1, 3, 200),

                new Student3("나자바", true, 2, 1, 300),
                new Student3("김지미", false, 2, 1, 250),
                new Student3("김자바", true, 2, 1, 200),
                new Student3("이지미", false, 2, 2, 150),
                new Student3("남자바", true, 2, 2, 100),
                new Student3("안지미", false, 2, 2, 50),
                new Student3("황지미", false, 2, 3, 100),
                new Student3("강지미", false, 2, 3, 150),
                new Student3("이자바", true, 2, 3, 200)
        };

        System.out.println("1. 단순그룹화(반별로 그룹화)");
        Map<Integer, List<Student3>> stuByBan = Stream.of(stuArr)
                .collect(Collectors.groupingBy(Student3::getBan));
        stuByBan.get(1).forEach(System.out::println);
        stuByBan.get(2).forEach(System.out::println);
        stuByBan.get(3).forEach(System.out::println);

        System.out.println("\n2. 단순그룹화(성적별로 그룹화)");
        Map<Student3.Level, List<Student3>> stuByLevel = Stream.of(stuArr)
                .collect(Collectors.groupingBy(s -> {
                    if (s.getScore() >= 200) {
                        return Student3.Level.HIGH;
                    } else if (s.getScore() >= 100) {
                        return Student3.Level.MID;
                    } else {
                        return Student3.Level.LOW;
                    }
                }));
        TreeSet<Student3.Level> keySet = new TreeSet<>(stuByLevel.keySet());
        keySet.forEach(level -> {
            System.out.println("[" + level + "]");
            stuByLevel.get(level).forEach(System.out::println);
        });

        System.out.println("\n3. 단순그룹화 + 통계(성적별 학생수)");
        Map<Student3.Level, Long> cntByLevel = Stream.of(stuArr).collect(Collectors.groupingBy(s -> {
            if (s.getScore() >= 200) {
                return Student3.Level.HIGH;
            } else if (s.getScore() >= 100) {
                return Student3.Level.MID;
            } else {
                return Student3.Level.LOW;
            }
        }, Collectors.counting()));
        cntByLevel.forEach((level, aLong) -> System.out.println(level + " - " + aLong));

        System.out.println("\n4. 다중그룹화(학년별, 반별)");
        Map<Integer, Map<Integer, List<Student3>>> stuByHakAndBan = Stream.of(stuArr)
                .collect(Collectors.groupingBy(Student3::getHak
                        , Collectors.groupingBy(Student3::getBan)
                ));

        stuByHakAndBan.forEach((i, map) -> {
            map.forEach((k, v) -> {
                System.out.println(i + "학년" + k + "반");
                v.forEach(System.out::println);
            });
        });

        System.out.println("\n5. 다중그룹화 + 통계(학년별, 반별 1등)");
        Map<Integer, Map<Integer, Student3>> topStuByHakBan = Stream.of(stuArr)
                .collect(Collectors.groupingBy(Student3::getHak
                        , Collectors.groupingBy(Student3::getBan
                                , Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparingInt(Student3::getScore))
                                        , Optional::get
                                ))
                ));
        topStuByHakBan.forEach((h, b) -> {
            b.forEach((k, v) -> {
                System.out.println(v);
            });
        });

        System.out.println("\n6. 다중그룹화 + 통계(학년별, 반별 성적그룹)");
//        Map<Integer, Map<Integer, Set<Student3.Level>>> stuByScoreGroup = Stream.of(stuArr)
//                .collect(Collectors.groupingBy(Student3::getHak
//                        ,Collectors.groupingBy(Student3::getBan
//                                , Collectors.mapping(s -> {
//                                    if(s.getScore() >= 200) {
//                                        return Student3.Level.HIGH;
//                                    } else if (s.getScore() >= 100) {
//                                        return Student3.Level.MID;
//                                    } else {
//                                        return Student3.Level.LOW;
//                                    }
//                                }, Collectors.toSet()))
//                ));
//
//        stuByScoreGroup.forEach((h, b) -> {
//            b.forEach((k, v) -> {
//                System.out.printf("[%d - %d] %s%n", h, k, v);
//            });
//        });
        Map<String, Set<Student3.Level>> stuByScoreGroup = Stream.of(stuArr)
                .collect(Collectors.groupingBy(s -> s.getHak() + "-" + s.getBan()
                        , Collectors.mapping(s -> {
                            if (s.getScore() >= 200) {
                                return Student3.Level.HIGH;
                            } else if (s.getScore() >= 100) {
                                return Student3.Level.MID;
                            } else {
                                return Student3.Level.LOW;
                            }
                        }, Collectors.toSet())
                ));

        stuByScoreGroup.forEach((k, v) -> {
            System.out.println("[" + k + "]" + v);
        });

    }
}
