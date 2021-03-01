package lambdaTheory.loop2;

@FunctionalInterface
interface MyFunction2{
    public abstract void myMethod();
}

public class LambdaEx02 {
    public static void main(String[] args) {
        MyFunction2 f = ()->{}; // (MyFunction2) ( ()->{} );
        Object obj = (MyFunction2) ( ()->{} );
        String str =  ((Object) ((MyFunction2) (()->{} ))).toString();

        System.out.println(f);
        System.out.println(obj);
        System.out.println(str);
    }
}
