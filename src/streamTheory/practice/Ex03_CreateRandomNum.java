package streamTheory.practice;

import java.util.Random;
import java.util.stream.IntStream;

public class Ex03_CreateRandomNum {
    public static void main(String[] args) {
        IntStream intStream = new Random().ints();  // 무한스트림
        intStream
                .limit(5)   // 5개만 자르기
                .forEach(System.out::println);
        System.out.println();

        intStream = new Random().ints(5);  // 스트림 사이즈 5
        intStream.forEach(System.out::println);

        System.out.println();

        intStream = new Random().ints(10, 5, 10);  // 스트림 사이즈 5
        intStream.forEach(System.out::println);

    }
}
