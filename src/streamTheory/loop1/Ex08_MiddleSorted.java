package streamTheory.loop1;

import java.util.Comparator;
import java.util.stream.Stream;

public class Ex08_MiddleSorted {
    public static Stream<Student> makeStream() {
        Stream<Student> streamStudent = Stream.of(
                new Student("김자바", 1, 200),
                new Student("안자바", 2, 100),
                new Student("박자바", 2, 150),
                new Student("소자바", 1, 200),
                new Student("이자바", 3, 300),
                new Student("나자바", 3, 290),
                new Student("감자바", 3, 180)
        );

        return streamStudent;
    }

    public static void main(String[] args) {
        makeStream().sorted(Comparator.comparing(Student::getBan)
                .thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);
        System.out.println("=================");

        makeStream().sorted(Comparator.comparing(Student::getBan).reversed()
                .thenComparing(Comparator.naturalOrder()).reversed())
                .forEach(System.out::println);
        System.out.println("=================");

        makeStream().sorted(Comparator.comparing((Student s) -> s.getBan())
                .thenComparing(Comparator.naturalOrder()))
                .forEach(s -> System.out.println(s));
    }
}

class Student implements Comparable<Student> {
    String name;
    int ban;
    int totalScore;

    public Student(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
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
    public String toString() {
        return String.format("[%s, %d, %d]", name, ban, totalScore);
    }

    @Override
    public int compareTo(Student s) {
        return s.totalScore - this.totalScore;
    }

}