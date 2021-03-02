package lambdaTheory.loop3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LambdaEx04 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        // list의 모든 요소를 출력
        list.forEach(integer -> System.out.print(integer + ", "));
        System.out.println();

        // list의 2, 3의 배수를 제거한다.
        list.removeIf(i -> i % 2 == 0 || i % 3 == 0 );
        System.out.println(list);

        // list의 각 인덱스에 10을 곱한다
        list.replaceAll(i -> i*10);
        System.out.println(list);

        Map<String, String> map = new HashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");

        map.forEach((k, v) -> System.out.println(k + " : " + v));
        map.replaceAll((k, v) -> {
            if (k.equals("2")){
                v += "2";
            }
            return v;
        });

        map.forEach((s, s2) -> System.out.println(s2 + ", "));

    }
}
