package streamTheory.loop2;


import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex15_FinalPartitioningBy {
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

        System.out.println("1. 단순분할(성별로 분할)");
        Map<Boolean, List<Student>> stuBySex = Stream.of(stuArr).collect(Collectors.partitioningBy(Student::isMale));
        System.out.println("남자 학생 - " + stuBySex.get(true));
        System.out.println("여자 학생 - " + stuBySex.get(false));

        System.out.println("\n2. 단순분할 + 통계(성별 학생수)");
        Map<Boolean, Long> countBySex = Stream.of(stuArr).collect(Collectors.partitioningBy(Student::isMale, Collectors.counting()));
        System.out.println(countBySex);

        System.out.println("\n3. 단순분할 + 통계(성별 1등)");
        Map<Boolean, Optional<Student>> topBySex = Stream.of(stuArr).collect(
                Collectors.partitioningBy(
                        Student::isMale
                        , Collectors.maxBy(
                                Comparator.comparing(Student::getScore))
                )
        );
        System.out.println(topBySex);
        Map<Boolean, Student> topBySex2 = Stream.of(stuArr).collect(
                Collectors.partitioningBy(
                        Student::isMale,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(Student::getScore))
                                , Optional::get
                        )
                )
        );

        System.out.println("\n 다중분할(성별 불합격자, 100점 이하)");
        Map<Boolean, Map<Boolean, List<Student>>> stuByScore = Stream.of(stuArr).collect(Collectors.partitioningBy(Student::isMale
                , Collectors.partitioningBy(student -> student.getScore() <= 100)));

        System.out.println(stuByScore);
    }
}
