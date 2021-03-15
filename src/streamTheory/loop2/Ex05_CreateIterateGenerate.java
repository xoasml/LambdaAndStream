package streamTheory.loop2;

import java.util.stream.Stream;

public class Ex05_CreateIterateGenerate {
    public static void main(String[] args) {
        System.out.println("loop2");
        //iterate(T seed, UnaryOperator f) 단항 연산자 || 시드가 있다
        Stream<Integer> intStream = Stream.iterate(1, i -> i + 2); // 무한 스트림
        intStream.limit(10).forEach(System.out::println);

        // generate(Supplier s) : 주기만 하는것 입력x, 출력o || 시드가없다
        intStream = Stream.generate(() -> 2); // 무한 스트림
        intStream.limit(10).forEach(System.out::println);

    }

}
