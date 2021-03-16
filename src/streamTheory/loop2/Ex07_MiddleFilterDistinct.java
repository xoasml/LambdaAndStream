package streamTheory.loop2;

import java.util.stream.IntStream;

public class Ex07_MiddleFilterDistinct {
    public static void main(String[] args) {
        IntStream intStream = IntStream.of(1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6);
        intStream.distinct().forEach(System.out::print);
        System.out.println();

        intStream = IntStream.rangeClosed(1, 10);
        intStream.filter(i -> i % 2 == 0).forEach(System.out::print);
        System.out.println();

        intStream = IntStream.rangeClosed(1, 10);
        intStream.filter(i -> i % 2 != 0 && i % 3 != 0).forEach(System.out::print);
        System.out.println();

        intStream = IntStream.rangeClosed(1, 10);
        intStream.filter(i -> i % 2 != 0).filter(i -> i % 3 != 0).forEach(System.out::print);


    }

}
