package lambdaTheory.loop2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LambdaEx04 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        // TODO: 2021-02-28 리스트의 모든 인덱스 출력 
        list.forEach(i -> System.out.print(i+", "));
        System.out.println();

        // TODO: 2021-02-28 리스트의 2, 3 배수를 제거
        list.removeIf(i-> i%2 == 0 || i%3 == 0);
        System.out.println(list);

        // TODO: 2021-02-28 리스트의 각 요소에 10을 곱한다.
        list.replaceAll(i->i*10);
        System.out.println(list);

        Map<String, String> map = new HashMap<>();
        map.put("1","a");
        map.put("2","b");
        map.put("3","c");
        map.put("4","d");

        map.forEach((k, v) -> System.out.println(k + " : " + v));


    }


}
