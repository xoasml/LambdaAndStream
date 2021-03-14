package streamTheory.Example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx3 {
    public static void main(String[] args) {
        Student3[] stuArr = {
                new Student3("이자바", 3, 300),
                new Student3("김자바", 1, 200),
                new Student3("안자바", 2, 100),
                new Student3("박자바", 2, 150),
                new Student3("소자바", 1, 200),
                new Student3("나자바", 3, 290),
                new Student3("감자바", 3, 180)
        };

        Stream<Student3> stuStream = Stream.of(stuArr);

        stuStream.sorted(Comparator.comparing(Student3::getBan)
                .thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);

        stuStream = Arrays.stream(stuArr);
        IntStream stuScoreStream = stuStream.mapToInt(Student3::getTotalScore);

        IntSummaryStatistics stat = stuScoreStream.summaryStatistics();
        System.out.println("count : " + stat.getCount());
        System.out.println("sum : " + stat.getSum());
        System.out.printf("avg : %.2f", stat.getAverage());
        System.out.println("min : " + stat.getMin());
        System.out.println("max : " + stat.getMax());

    }
}

class Student3 implements Comparable<Student3> {
    String name;
    int ban;
    int totalScore;

    public Student3(String name, int ban, int totalScore) {
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
        return String.format("[%s, %d, %d]", name, ban, totalScore).toString();
    }

    @Override
    public int compareTo(Student3 o) {
        return o.totalScore - this.totalScore;
    }
}
