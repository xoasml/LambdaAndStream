package lambdaTheory.loop4;

@FunctionalInterface
interface MyFunction{
    void run();
}

public class LambdaEx01 {
    static void excute(MyFunction f) {
        f.run();
    }

    static MyFunction getMyFunction() {
        MyFunction f = () -> System.out.println("f3.run()");
        return f;
    }

    public static void main(String[] args) {
        // 람다식으로 MyFunction의 run()을 구현
        MyFunction f1 = () -> System.out.println("f1.run()");

        // 익명 클래스로 MyFunction의 run()을 구현
        MyFunction f2 = new MyFunction() {
            @Override
            public void run() {
                System.out.println("f2.run()");
            }
        };

        MyFunction f3 = getMyFunction();

        f1.run();
        f2.run();
        f3.run();

        excute(f1);
        excute(() -> System.out.println("run()"));
    }
}
