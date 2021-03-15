package streamTheory.loop2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ex01_CreateCollection {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream = list.stream();
        stream.forEach(System.out::print);
        System.out.println();

        // Stream은 1회용 이기 때문에 재사용이 안된다, 다시 만들어야 한다.
        stream = list.stream();
        stream.forEach(System.out::print);
    }
}
