package streamTheory.loop2;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex02_CreateArray {
    public static void main(String[] args) {
        Stream<String> strStream = Stream.of("a", "b", "c");
        System.out.println(strStream.collect(Collectors.joining(", ", "[", "]")));

        strStream = Stream.of(new String[]{"a", "b", "c"});
        System.out.println(strStream.collect(Collectors.joining(", ", "[", "]")));

        String[] strArr = {"a", "b", "c", "d"};
        strStream = Stream.of(strArr);
        System.out.println(strStream.collect(Collectors.joining(", ", "[", "]")));

        strStream = Arrays.stream(strArr);
        System.out.println(strStream.collect(Collectors.joining(", ", "[", "]")));

        // 배열을 List로
        int[] intArr = {1, 2, 3, 4, 5};
        IntStream intStream = Arrays.stream(intArr);
//        intStream.map(s -> s+"").collect(Collectors.joining(", ", "[", "]")); // boxed를 해주어야 한다.
        intStream.boxed().map(s -> s+"").collect(Collectors.joining(", ", "[", "]"));
        intStream = Arrays.stream(intArr);
//        List<Integer> list = intStream.collect(Collectors.toList()); // int는 Integer에 넣을수 없다.
        List<Integer> list = intStream.boxed().collect(Collectors.toList()); // boxed()를 이용해서 int를  Integer로 랩핑해준다.
        System.out.println(list.stream().map(s -> s+"").collect(Collectors.joining(", ", "[","]")));

        intStream = Arrays.stream(intArr);
        System.out.println(intStream.count());
        intStream = Arrays.stream(intArr);
        System.out.println(intStream.sum());
        intStream = Arrays.stream(intArr);
        System.out.println(intStream.average());
    }
}
