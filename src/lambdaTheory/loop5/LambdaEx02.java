package lambdaTheory.loop5;

@FunctionalInterface
interface MyFunction2{
    void myMethod();
}

public class LambdaEx02 {
    public static void main(String[] args) {
        MyFunction f = () -> {};
        Object obj = (MyFunction) () -> {};
        String str = ((Object) ((MyFunction) () -> {})).toString();

        System.out.println(f);
        System.out.println(obj);
        System.out.println(str);

        System.out.println((MyFunction2) () -> {});
        System.out.println((Object)((MyFunction2) () -> {}));
    }
}
