package lambdaTheory.loop5;

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
        list.forEach(System.out::println);

        // list에서 2 와 3의 배수를 제거 한다.
        list.removeIf(integer -> integer%2==0 || integer%3==0);
        System.out.println(list);

        // list의 각 요소에 10을 곱한다.
        list.replaceAll(i -> i*10);
        System.out.println(list);

        Map<String, String> map = new HashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");

        // map의 모든 요소를 {k, v}의 형태로 출력
        map.forEach((s, s2) -> System.out.println(s + " : " + s2));

        // map의 요소중 key가 2인 인덱스의 값에 "O"를 붙인다
        map.replaceAll((s, s2) -> s.equals("2") ? s2+"O" : s2);
        System.out.println(map);
    }


}
