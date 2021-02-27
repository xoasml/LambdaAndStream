package lambdaTheory.loop1;

@FunctionalInterface
interface  MyFunction{
    void run(); // public abstract void run();
}

public class No01LambdaEx01 {
    static void excute(MyFunction f) { // 매개변수의 타입이 Myfunction인 메서드
        f.run();
    }

    static MyFunction getMyFunction() { // 반환 타입이 MyFcuntion인 메서드
        MyFunction f = () -> System.out.println("f3.run()");
        return f;
    }

    public static void main(String[] args) {
        MyFunction f1 = () -> System.out.println("f1.run()");
        MyFunction f2 = () -> System.out.println("f2.run()");
        MyFunction f3 = getMyFunction();

        MyFunction f4 = new MyFunction() {
            @Override
            public void run() {
                System.out.println("f4.run()");
            }
        };

        f1.run();
        f2.run();
        f3.run();
        f4.run();
        excute(f1);
        excute(()-> System.out.println(".run()"));

    }
}
