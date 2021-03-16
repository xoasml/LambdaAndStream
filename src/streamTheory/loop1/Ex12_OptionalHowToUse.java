package streamTheory.loop1;

import java.util.Optional;
import java.util.OptionalInt;

public class Ex12_OptionalHowToUse {
    public static void main(String[] args) {
        Optional<String> optStr = Optional.of("abcde");
//        Optional<Integer> optInt = optStr.map(String::length);
        Optional<Integer> optInt = optStr.map(s-> s.length());
        System.out.println("optStr=" + optStr.get());
        System.out.println("optInt=" + optInt.get());

        int result1 = Optional.of("123")
                .filter(x -> x.length() > 0)
                .map(((s) -> Integer.parseInt(s))).get();

        int result2 = Optional.of("")
                .filter(x -> x.length() > 0)
                .map(x -> Integer.parseInt(x))
                .orElse(-1);

        System.out.println("result1=" + result1);
        System.out.println("result2=" + result2);

        Optional.of("456").map(Integer::parseInt)
                .ifPresent(x -> System.out.printf("result3=%s%n", x));

        OptionalInt optInt1 = OptionalInt.of(0);    // 0을 저장
        OptionalInt optInt2 = OptionalInt.empty();  // 빈 객체를 생성

        System.out.println(optInt1.isPresent());    // true
        System.out.println(optInt2.isPresent());    // false

        System.out.println(optInt1.getAsInt());     // 0
//        System.out.println(optInt2.getAsInt());     // NoSuchElementException

        System.out.println("optInt1=" + optInt1);
        System.out.println("optInt2=" + optInt2);
        System.out.println("optInt1.equals(optInt2) ? " + optInt1.equals(optInt2));

        Optional<String> opt = Optional.ofNullable(null);   // null을 저장
        Optional<String> opt2 = Optional.empty();           // 빈 객체를 생성
        System.out.println("opt =" + opt);
        System.out.println("opt2 = " + opt2);
        System.out.println("opt.equals(opt2)?" + opt.equals(opt2)); // true

        int result3 = optStrToInt(Optional.of("123"), 0);
        int result4 = optStrToInt(Optional.of(""), 0);

        System.out.println("result3 = " + result3);
        System.out.println("result4 = " + result4);
    }

    private static int optStrToInt(Optional<String> s, int i) {
        try {
            return s.map(Integer::parseInt).get();
        } catch (Exception e) {
            return i;
        }
    }
}
