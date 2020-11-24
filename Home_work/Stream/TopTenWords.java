package Home_work.Stream;

import com.itmo.jjd.Lesson22.Lambda.Course;
import com.sun.jdi.Value;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class TopTenWords {
    public static void main(String[] args) {
        // создать Map<String, Long> map
        // String - словоLo
        // Long - частота встречаемости
        // в мапу должны войти только первые 10 частоте встречаемости слов

        // содержимое файла может быть любым
        // Map<String, Long> map = Files.lines(Paths.get("sources/task23.txt")) // читаем из файла в stream
        // методы вызывать по цепочке,
        // цепочку не разрывать (пока не получите результирующую мапу)

        try {
            Map<String, Long> map = Files.lines(Paths.get("somefile.txt"))
                    .flatMap(s -> Stream.of(s.split(" ")))
                    .map(elem -> new String(elem))
                    .collect(Collectors.toMap(k -> k.toString(), v -> 1L, (v1, v2) -> v1 + v2))
                    .entrySet().stream().sorted((item1, item2) ->
                            item2.getValue().compareTo(item1.getValue())).limit(10)
                    .collect(Collectors.toMap(k -> k.getKey(), s -> s.getValue()));

            System.out.println(map);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}