package Home_work.Lambda;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.*;

public class HomeWork1 {
    /*
    Отработать написание лямбда (написать по 2 реализации) для: Predicate, Function, UnaryOperator, BinaryOperator, Consumer
     */
    public static void main(String[] args) {
        String st = "name@domain.com";
        Map<Integer, String> someMap = new HashMap<>();
        someMap.put(0, "test");
        someMap.put(1, "Hello!");
        someMap.put(2, st);

        Predicate<String> existSymbol = txt -> txt.contains("@");
        Predicate<HashMap<Integer, String>> containsValue = anyMap -> anyMap.containsValue(st);

        System.out.println(existSymbol.test(st));
        System.out.println(containsValue.test((HashMap<Integer, String>) someMap));

        //************************************

        Function<HashMap<Integer, String>, String> returnValue = map1 -> map1.get(1);
        Function<String, Integer> returnStrLength = str2 -> str2.length();

        System.out.println(returnValue.apply((HashMap<Integer, String>) someMap));
        System.out.println(returnStrLength.apply(st));

        //***********************************

        UnaryOperator<String> txtFormat = str3 -> str3.trim().toUpperCase();
        UnaryOperator<ArrayList<Integer>> arr = arr1 -> {
            for(int i = 0; i < 10; i++){
                arr1.add(i*2);
            }
            return arr1;
        };
        System.out.println(txtFormat.apply("             hello!                     "));
        System.out.println(arr.apply(new ArrayList<>()).toString());

        //***********************************

        BinaryOperator<Integer> maxCount = BinaryOperator.maxBy((a, b) -> (a > b) ? 1 : (a == b) ? 0 : -1);
        BinaryOperator<Integer> minCount = BinaryOperator.minBy((c, d) -> (c < d) ? -1 : (c == d) ? 0: 1);

        System.out.println(maxCount.apply(500, 300));
        System.out.println(minCount.apply(200, 50));

        //***********************************

        Consumer<String> printStrUpper = printTxt -> System.out.println(printTxt.toUpperCase());
        Consumer<String> printStrFormat = printTxt -> System.out.println("\"" + printTxt + "\"");

        printStrFormat.andThen(printStrUpper).accept("hello");

    }
}
