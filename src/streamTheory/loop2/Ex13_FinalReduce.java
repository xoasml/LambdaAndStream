package streamTheory.loop2;

import java.util.Optional;
import java.util.stream.Stream;

import static com.sun.xml.internal.ws.policy.sourcemodel.wspolicy.XmlToken.Optional;

public class Ex13_FinalReduce {
    public static void main(String[] args) {
        String[] strArr = {
                "Inheritance", "Java", "Lambda", "stream",
                "OptionalDouble", "IntStream", "count", "sum"
        };

        Stream.of(strArr)
                .parallel() // 병렬로 처리
                .forEachOrdered(System.out::println); // 병렬이어도 순서대로 처리 됨

//        allMatch()  : 모든게 매치되야 true
//        anyMatch()  : 하나라도 매치되면 true
//        noneMatch() : 하나도 매치되는게 없으면 true
        boolean noEmptyStr = Stream.of(strArr).noneMatch(s -> s.length() == 0); // 하나도 매치되는게 없으면 true
        System.out.println(noEmptyStr);

        Optional<String> sWord = Stream.of(strArr)
                .filter(s -> s.charAt(0) == 's').findFirst();
        System.out.println(sWord.get());

//        Stream<String>을 Stream<Integer>로 변환 -> s.length()
        Stream<Integer> integerStream = Stream.of(strArr).map(String::length);
        Optional<Integer> opt = integerStream.reduce(Integer::min);


    }
}
