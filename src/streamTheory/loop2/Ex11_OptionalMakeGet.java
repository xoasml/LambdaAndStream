package streamTheory.loop2;

import java.util.Optional;

public class Ex11_OptionalMakeGet {
    public static void main(String[] args) {
        int[] arr = new int[0];
        System.out.println("arr.length = " + arr.length);

//        Optional<String> opt = null; // Ok, 하지만 바람직 X
        Optional<String> opt = Optional.empty();
//        Optional<String> opt = Optional.of("abc");
        System.out.println("opt = "+opt);
//        System.out.println("opt = " + opt.get()); // get을 잘 쓰지 않음

        String str = "";
        str = opt.orElse("EMPTY");
        System.out.println(str);
        str = opt.orElseGet(String::new);
        System.out.println(str);
        str = opt.orElseGet(() -> new String());
        System.out.println(str);
        str = opt.orElseGet(() -> "EMPTY");
        System.out.println(str);
    }
}
