package streamTheory.loop2;


import java.util.Comparator;
import java.util.stream.Stream;

public class Ex08_MiddleSorted {
    public static void main(String[] args) {
        MiddleStu[] stuArr = {
                new MiddleStu("김자바", 1, 200),
                new MiddleStu("안자바", 2, 100),
                new MiddleStu("박자바", 2, 150),
                new MiddleStu("소자바", 1, 200),
                new MiddleStu("이자바", 3, 300),
                new MiddleStu("나자바", 3, 290),
                new MiddleStu("감자바", 3, 180)
        };

        Stream.of(stuArr).sorted(Comparator.comparing(MiddleStu::getBan)
                .thenComparing(Comparator.reverseOrder()))
                .forEach(System.out::println);
        System.out.println("=================");

        Stream.of(stuArr).sorted(Comparator.comparing(MiddleStu::getBan).reversed()
                .thenComparing(Comparator.naturalOrder()).reversed())
                .forEach(System.out::println);
        System.out.println("=================");

        Stream.of(stuArr).sorted(Comparator.comparing((MiddleStu s) -> s.getBan())
                .thenComparing(Comparator.naturalOrder()))
                .forEach(s -> System.out.println(s));

    }
}
