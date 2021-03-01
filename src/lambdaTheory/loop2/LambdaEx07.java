package lambdaTheory.loop2;

import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaEx07 {
    public static void main(String[] args) {
        Function<String, Integer> f = string -> Integer.parseInt(string,16);
        Function<Integer, String> g = Integer::toBinaryString;

        Function<String, String> h = f.andThen(g);
        Function<Integer, Integer> h2 = f.compose(g);

        System.out.println(h.apply("FF"));
        System.out.println(h2.apply(2));

        Function<String, String> f2 = x -> x;
        Function<String, String> ff2 = Function.identity();
        System.out.println(f2.apply("AAA"));
        System.out.println(ff2.apply("BBB"));

        Predicate<Integer> p = integer -> integer < 100;
        Predicate<Integer> q = integer -> integer < 200;
        Predicate<Integer> r = integer -> integer%2 == 0;
        Predicate<Integer> notP = p.negate(); // integer >= 100;

        Predicate<Integer> all = notP.and(q.or(r));
        System.out.println(all.test(150));

        String str1 = "abc";
        String str2 = "abc";

        Predicate<String> p2 = Predicate.isEqual(str1);
        System.out.println(p2.test(str2));
    }
}
