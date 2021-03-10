package lambdaTheory.loop5;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaEx05 {
    public static void main(String[] args) {
        Supplier<Integer> s = () -> (int) (Math.random() * 100) + 1;
        Consumer<Integer> c = integer -> System.out.print(integer + ", ");
        Predicate<Integer> p = integer -> integer % 2 == 0;
        Function<Integer, Integer> f = integer -> integer / 10 * 10;

        List<Integer> list = new ArrayList<>();
        makeRandomList(s, list);
        System.out.println(list);

        printEvenNum(p, c, list);

        List<Integer> newList = doSomething(f, list);
        System.out.println(newList);

    }

    static <T> void makeRandomList(Supplier<T> s, List<T> list) {
        for (int i = 0; i < 10; i++) {
            list.add(s.get());
        }
    }

    static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
        for (T t : list) {
            if (p.test(t)) {
                c.accept(t);
            }
        }
        System.out.println();
    }

    static <T> List<T> doSomething(Function<T, T> f, List<T> list) {
        List<T> newList = new ArrayList<>();
        for (T t : list) {
            newList.add(f.apply(t));
        }
        return newList;
    }


}
