package streamTheory.loop2;

import java.util.Optional;
import java.util.OptionalInt;

public class Ex12_OptionalHowToUse {
    public static void main(String[] args) {
        Optional<String> optStr = Optional.of("abcde");

//        Optional<Integer> optInt = optStr.map(String::length);
        Optional<Integer> optInt = optStr.map(s -> s.length());
        System.out.println("optStr = " + optStr.orElse(null));
        System.out.println("optInt = " + optInt.orElse(0));

        int result1 = Optional.of("123")
                .filter(s -> s.length() > 0)
                .map(Integer::parseInt).orElse(0);

        int result2 = Optional.of("")
                .filter(s -> s.length() > 0)
                .map(Integer::parseInt).orElse(0);

        System.out.println(result1);
        System.out.println(result2);

//         ifPresent : Optional의 값이 null이 아니면 실행
        Optional.of("456").map(Integer::parseInt)
                .ifPresent(x -> System.out.printf("result3=%s%n", x));

//        isPresent : Optional의 값이 null이면 false, null이 아니면 true를 반환
        OptionalInt intOpt1 = OptionalInt.of(0);
        System.out.println(intOpt1.isPresent());

        OptionalInt intOpt2 = OptionalInt.empty();
        System.out.println(intOpt2.isPresent());

//      getAsInt(), orElse(), orElseGet()
        int optTest = intOpt1.getAsInt();
        System.out.println(optTest);

        System.out.println(intOpt1); // OptionalInt[0]
        System.out.println(intOpt2); // OptionalInt.empty
        System.out.println("intOpt1.equals(intOpt2) ? " + intOpt1.equals(intOpt2));

        Optional<String> opt = Optional.ofNullable(null);   // null을 저장
        Optional<String> opt2 = Optional.empty();           // 빈 객체를 저장
        System.out.println("opt : " + opt);
        System.out.println("opt2 : " + opt2);
        System.out.println("opt.equals(opt2) ? " + opt.equals(opt2)); // true

        int result3 = optStrToint(Optional.of("123"), 0);
        int result4 = optStrToint(Optional.of(""), 0);

        System.out.println("result3 = " + result3);
        System.out.println("result4 = " + result4);
    }

    private static int optStrToint(Optional<String> s, int i) {
        try {
            return s.map(Integer::parseInt).get();
        } catch (Exception e) {
            return i;
        }
    }
}
