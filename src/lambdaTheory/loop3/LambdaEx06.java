package lambdaTheory.loop3;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;

public class LambdaEx06 {
    public static void main(String[] args) {
        IntSupplier s = () -> (int) (Math.random() * 100) + 1;
        IntConsumer c = i -> System.out.print(i + ", ");
        IntPredicate p = value -> value % 2 == 0;
        IntUnaryOperator op = i -> i / 10 * 10;

        int[] arr = new int[10];

        makeRandomArr(s, arr);
        System.out.println(Arrays.toString(arr));
        printEvenNum(p, c, arr);
        int[] newArr = doSomeThing(op, arr);
        System.out.println(Arrays.toString(newArr));
    }

    static void makeRandomArr(IntSupplier s, int[] arr) {
        for (int i = 0; i < 10; i++) {
            arr[i] = s.getAsInt();
        }
    }

    static void printEvenNum(IntPredicate p, IntConsumer c, int[] arr) {
        System.out.print("[");
        for (int i : arr) {
            if (p.test(i)) {
                c.accept(i);
            }
        }
        System.out.println("]");
    }

    static int[] doSomeThing(IntUnaryOperator op, int[] arr) {
        int[] newArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = op.applyAsInt(arr[i]);
        }

        return newArr;
    }

}
