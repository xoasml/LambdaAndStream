package lambdaTheory.loop5;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;

public class LambdaEx06 {
    public static void main(String[] args) {
        IntSupplier s = () -> (int) (Math.random() * 100) + 1;
        IntConsumer c = value -> System.out.print(value + ", ");
        IntPredicate p = value -> value % 2 == 0;
        IntUnaryOperator op = operand -> operand / 10 * 10;

        int[] arr = new int[10];

        makeRandomArr(s, arr);
        System.out.println(Arrays.toString(arr));

        getEvenNum(p, c, arr);

        int[] newArr = doSomething(op, arr);
        System.out.println(Arrays.toString(newArr));
    }

    static void makeRandomArr(IntSupplier s, int... arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.getAsInt();
        }
    }

    static void getEvenNum(IntPredicate p, IntConsumer c, int... arr) {
        for (int i : arr) {
            if (p.test(i)) {
                c.accept(i);
            }
        }
        System.out.println();
    }

    static int[] doSomething(IntUnaryOperator op, int... arr) {
        int[] newArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = op.applyAsInt(arr[i]);
        }

        return newArr;
    }

}
