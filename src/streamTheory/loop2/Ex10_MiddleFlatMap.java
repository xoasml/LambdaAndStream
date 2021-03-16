package streamTheory.loop2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex10_MiddleFlatMap {
    public static void main(String[] args) {
        Stream<String[]> strArrStrm = Stream.of(
                new String[]{"abc", "def", "jkl"},
                new String[]{"ABC", "GHI", "JKL"}
        );

        Stream<String> strStrm = strArrStrm.flatMap(Arrays::stream);

        strStrm.map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        System.out.println();

        String[] lineArr = {
                "Believe or not It is true",
                "Do or do not There is no try"
        };

        Stream.of(lineArr).flatMap(s -> Stream.of(s.split(" +")))
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        Stream<String> strStrm1 = Stream.of("AAA", "ABC", "bBb", "Dd");
        Stream<String> strStrm2 = Stream.of("bbb", "aaa", "ccc", "dd");

        Stream<Stream<String>> strStrmStrm = Stream.of(strStrm1, strStrm2);
        Stream<String> strStream = strStrmStrm
                // Stream.toArray(String[]::new) 각각 두개의 스트림을 스트링 배열로 변환
                .map(s -> s.toArray(String[]::new))
                // 스트링 배열로 바꾼걸 다시 하나의 스트림으로 합치기
                .flatMap(Arrays::stream);

        List<String> list = strStream
                .map(String::toLowerCase)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(list);
    }
}
