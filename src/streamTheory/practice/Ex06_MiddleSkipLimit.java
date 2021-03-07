package streamTheory.practice;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex06_MiddleSkipLimit {
    public static void main(String[] args) {
//        Stream<T> skip (long n) // 앞에서부터 n개 건너뛰기
//        Stream<T> limit(long maxSize) // maxSize 이후의 요소는 잘라냄

        IntStream intStream = IntStream.rangeClosed(1, 10);
        intStream.skip(3) // 1 2 3 컷 4 5 6 7 8 9 10
                .limit(5) // 4 5 6 7 8 컷 9 10
                .forEach(System.out::println);
    }
}
