package lambdaTheory.loop1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class No04LambdaEx04 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        // list의 모든 요소를 출력
        list.forEach(i -> System.out.print(i+","));
//        list.forEach(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) {
//                System.out.print(integer+",");
//            }
//        });
        System.out.println();

        // 2, 3의 배수를 제거
        list.removeIf(i -> i%2==0 || i%3==0);
//        list.removeIf(new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) {
//                if (integer%2==0 || integer%3==0){
//                    return true;
//                } else {
//                    return false;
//                }
//            }
//        });
        System.out.println(list);

        list.replaceAll(i -> i*10);
//        list.replaceAll(new UnaryOperator<Integer>() {
//            @Override
//            public Integer apply(Integer integer) {
//                return integer*10;
//            }
//        });
        System.out.println(list);

        Map<String, String> map = new HashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");

        // 맵의 모든 요소를 k,v의 형식으로 출력한다.
        map.forEach((i, e) -> System.out.println(i +", " + e));
    }
}
