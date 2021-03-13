package streamTheory.practice;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// reduce(identity(초기값), accumulator 누적 수행 작업) : 리듀싱 - 전체에 대한
// collect(Collector 인터페이스) : 그룹별 리듀싱 - 그룹별로 나누어서

public class Ex13_FinalReduce {
    public static void main(String[] args) {
        String[] strArr = {
                "Inheritance", "Java", "Lambda", "stream",
                "OptionalDouble", "IntStream", "count", "sum"
        };

        Stream.of(strArr)
                .parallel() // parallel병렬로 처리
                .forEachOrdered(System.out::println); // forEachOrdered 병렬 처리 일때 순서대로 처리 되게 해준다

        boolean noEmptyStr = Stream.of(strArr).noneMatch(s -> s.length() == 0);
        System.out.println(noEmptyStr);

        Optional<String> sWord = Stream.of(strArr)
                .filter(s -> s.charAt(0) == 's').findFirst();
        System.out.println(sWord.get());


        // Stream<String>을 Stream<Integer>으로 변환 s -> s.length()
        Stream<Integer> integerStream = Stream.of(strArr).map(String::length);
        Optional<Integer> opt = integerStream.reduce(Integer::min);
        System.out.println(opt.get());

        // Stream<String>을 IntStream으로 변환
        IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);

        int count = intStream1.reduce(0, (a, b) -> a + 1);
        int sum = intStream2.reduce(0, (a, b) -> a + b);

        OptionalInt max = intStream3.reduce(Integer::max);
        OptionalInt min = intStream4.reduce(Integer::min);

        System.out.println("count=" + count);
        System.out.println("sum=" + sum);
        System.out.println("max=" + max.getAsInt());
        System.out.println("min=" + min.getAsInt());

        OptionalInt testOpt1 = OptionalInt.empty(); // 빈 옵셔널
        Optional<Integer> testOpt2 = Optional.empty(); // 빈 옵셔널

        System.out.println(testOpt1.orElse(0)); // 옵셔널이 비어 있으면 0을 반환
        System.out.println(testOpt2.orElseGet(() -> 0)); // 옵셔널이 비어 있으면 0을 반환(람다식)
    }
}
