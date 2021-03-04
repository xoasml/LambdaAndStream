package streamTheory.practice;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex05_CreateIterateGenerate {
    public static void main(String[] args) {

        // iterate(T seed, UnaryOperator f) 단항 연산자 || 시드가 있다
        Stream<Integer> intStream = Stream.iterate(1, integer -> integer + 2);  // 무한 스트림
        intStream.limit(10).forEach(System.out::println);


        // generate(Supplier s) : 주기만 하는것 입력x, 출력 O || 시드가 없다
        Stream<Integer> intStream1 = Stream.generate(() -> 2); // 무한 스트림
        intStream1.limit(10).forEach(System.out::println);
    }
}
