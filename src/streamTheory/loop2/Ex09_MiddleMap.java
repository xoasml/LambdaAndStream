package streamTheory.loop2;

import java.io.File;
import java.util.Locale;
import java.util.stream.Stream;

public class Ex09_MiddleMap {
    public static void main(String[] args) {
        File[] fileArr = {
                new File("Ex1.java")
                , new File("Ex1.bak")
                , new File("Ex2.java")
                , new File("Ex1")
                , new File("Ex1.txt")
        };

        Stream<File> fileStream = Stream.of(fileArr);
        Stream<String> fileNameStream = fileStream.map(File::getName);
        fileNameStream.forEach(System.out::println);

        System.out.println("===========");

        fileNameStream = Stream.of(fileArr).map(File::getName);

        fileNameStream.filter(s -> s.indexOf(".") > 0)
                .map(s -> s.substring(s.indexOf(".") + 1))
                .map(s -> s.toUpperCase(Locale.ROOT))  //Locale. 나라(한국, 미국, ...)
                .distinct()
                .forEach(System.out::print);
    }
}
