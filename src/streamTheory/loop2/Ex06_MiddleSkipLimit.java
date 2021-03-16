package streamTheory.loop2;


import java.util.stream.IntStream;

public class Ex06_MiddleSkipLimit {
    public static void main(String[] args) {
        System.out.println("loop2");
        IntStream intStream = IntStream.rangeClosed(1, 10);
        intStream.skip(3)
                .limit(5)
                .forEach(System.out::println);
    }

}
