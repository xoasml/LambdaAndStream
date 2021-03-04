package streamTheory.practice;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex02_CreateArray {
    public static void main(String[] args) {
        Stream<String> strStream = Stream.of("a", "b", "c");
        strStream.forEach(System.out::println);
        System.out.println();

        Stream<String> strStream2 = Stream.of(new String[]{"a", "b", "c"});
        strStream2.forEach(System.out::println);
        System.out.println();

        String[] strArr = {"a", "b", "c", "d"};
        Stream<String> strStream3 = Stream.of(strArr);
        strStream3.forEach(System.out::println);
        System.out.println();

        strStream3 = Arrays.stream(strArr);
        strStream3.forEach(System.out::println);
        System.out.println();

        int[] intArr = {1, 2, 3, 4, 5};
        IntStream intStream2 = Arrays.stream(intArr);
        intStream2.forEach(System.out::println);
        intStream2 = Arrays.stream(intArr);
        System.out.println("count : " + intStream2.count());
        intStream2 = Arrays.stream(intArr);
        System.out.println("sum : " + intStream2.sum());
        intStream2 = Arrays.stream(intArr);
        System.out.println("average : " + intStream2.average());


        Integer[] intArr2 = {1, 2, 3, 4, 5};
        Stream<Integer> intStream3 = Arrays.stream(intArr2);
        System.out.println("count : " + intStream3.count());
    }
}
