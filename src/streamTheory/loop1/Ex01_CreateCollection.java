package streamTheory.loop1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ex01_CreateCollection {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> intStream = list.stream(); // lsit로부터 Stream으로 생성
        intStream.forEach(System.out::print); // Stream 사용

        // Stream은 1회용
        intStream = list.stream(); // lsit로부터 Stream으로 생성
        intStream.forEach(System.out::print);
        System.out.println();

//        intStream = Stream.of(list);  // 이렇게는 못만듬
    }
}
