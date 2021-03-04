package lambdaTheory.loop4;

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
        list.forEach(System.out::print);
        System.out.println();

        // list에서 2 와 3의 배수를 제거 한다.
        list.removeIf(integer -> integer%2==0 || integer%3==0);
        System.out.println(list);

        // list의 각 요소에 10을 곱한다.
        list.replaceAll(integer -> integer*10);
        System.out.println(list);


        Map<String, String> map = new HashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");

        // map의 모든 요소를 {k, v}의 형태로 출력
        map.forEach((k, v) -> System.out.println(k + " : " + v));
        map.replaceAll((k, v) -> {
            if(k.equals("2")){
                return v+"2";
            }
                return v;
        });
        System.out.println(map);

        map.replaceAll((s, s2) -> s.equals("2") ? s2+"T" : s2);
        System.out.println(map);

    }
}
