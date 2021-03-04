package streamTheory.practice;

import java.util.stream.IntStream;

public class Ex04_CreateIntStreamRange {
    public static void main(String[] args) {
        // 닫는 범위 미포함
        IntStream intStream = IntStream.range(1, 5); // 1, 2, 3, 4
        intStream.forEach(System.out::print);

        System.out.println();

        // 닫는 범위 포함
        IntStream intStream1 = IntStream.rangeClosed(1, 5); // 1, 2, 3, 4, 5
        intStream1.forEach(System.out::print);
    }

}
