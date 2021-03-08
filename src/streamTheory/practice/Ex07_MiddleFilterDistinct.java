package streamTheory.practice;

import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex07_MiddleFilterDistinct {
    public static void main(String[] args) {
//        Stream<T> filter (Predicate<? super T> Predicate) // 조건에 맞지 않는 요소 제거
//        Stream<T> distinct()                              // 중복 제거

        IntStream intStream = IntStream.of(1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6);
        intStream.distinct().forEach(System.out::print);

        System.out.println();
        IntStream intStream1 = IntStream.rangeClosed(1, 10);
        intStream1.filter(value -> value%2==0).forEach(value -> System.out.print(value + ", "));
        System.out.println();

        intStream1 = IntStream.rangeClosed(1, 10);
        intStream1.filter(value -> value%2!=0 && value%3!=0).forEach(value -> System.out.print(value + ", "));
        System.out.println();

        intStream1 = IntStream.rangeClosed(1, 10);
        intStream1.filter(value -> value%2!=0).filter(value -> value%3!=0).forEach(value -> System.out.print(value + ", "));
        System.out.println();

    }
}
