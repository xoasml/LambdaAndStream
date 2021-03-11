package streamTheory.practice;

import java.io.File;
import java.util.Locale;
import java.util.stream.Stream;

public class Ex09_MiddleMap {
    public static void main(String[] args) {
        File[] fileArr = {new File("Ex1.java"), new File("Ex1.bak"),
                new File("Ex2.java"), new File("Ex1"), new File("Ex1.txt")};

        Stream<File> fileStream = Stream.of(fileArr);
        Stream<String> fileNameStream = fileStream.map(File::getName);

        fileNameStream.forEach(System.out::println);
        System.out.println("==========");

        fileNameStream = Stream.of(fileArr).map(File::getName);

        fileNameStream.filter(s -> s.indexOf(".") > 0)      // 확장자 없는것 제외
                .peek(s -> System.out.printf("filename=%s%n", s))
                .map(s -> s.substring(s.indexOf(".")+1))    // 확장자만 추출
                .peek(s -> System.out.printf("extension=%s%n", s))
                .map(s -> s.toUpperCase(Locale.ROOT))       // 대문자
                .distinct()                                 // 중복 제거
                .forEach(System.out::println);                // JAVABAKTXT
    }

}
