package com.itmo.jjd.Lesson16.HomeWork;

import com.itmo.jjd.Lesson16.User;

import java.util.*;

public class MapTask {
    public static void main(String[] args) {
        // TODO:: написать статический метод, который приннимает на вход мапу (firstTaskMap) и город (city)
        //  и формирует список (List) логинов, которые соответствуют переданному городу

        HashMap<String, String> firstTaskMap = new HashMap<>();
        firstTaskMap.put("qwe", "Тверь");
        firstTaskMap.put("asd", "Тверь");
        firstTaskMap.put("zxc", "Москва");
        firstTaskMap.put("rty", "Тверь");
        firstTaskMap.put("fgh", "Магадан");

        String city = "Тверь";

        System.out.println(someMethod2(firstTaskMap, city));


        // TODO:: дан список слов (words). Написать метод, который будет возвращать количество одинаковых слов с списке
        //  в виде Map<String, Integer>, где String - слово и Integer - количество повторений

        List<String> words = new ArrayList<>();
        words.add("may");
        words.add("august");
        words.add("june");
        words.add("may");
        words.add("may");
        words.add("july");
        words.add("may");
        words.add("august");
        words.add("august");

        System.out.println(someMethod3(words));


        // TODO:: дана мапа (customerMap).
        //  Написать метод, который принимает на вход агрументы int from и int to и возвращает новую мапу,
        //  в которую войдут все покупатели, возраст которых находится в диапазоне [from, to)

        HashMap<String, Customer> customerMap = new HashMap<>();
        customerMap.put("1", new Customer("Павел", "1", 23));
        customerMap.put("2", new Customer("Олег", "2", 17));
        customerMap.put("3", new Customer("Максим", "3", 48));
        customerMap.put("4", new Customer("Евгения", "4", 67));

        System.out.println(someMethod(customerMap, 17, 40));


        // TODO:: Задания по тексту (text). На каждый пункт - минимум один метод:
        //  1. написать метод, принимающий на вход слово и возвращающий частоту встречаемости данного слова в тексте
        //  2. написать метод, который собирает все слова в группы по количеству букв:
        //  например, в одну группу попадут слова: 3 - [the, war, jar, get, met...], в другую 2 - [on, up, no, of...]
        //  3. написать метод, который выводит в консоль топ 10 самых частых слов
        //  4. Вывести частоту встречаемости букв анг алфавита в данном тексте. Вывести в процентах для каждой буквы

        // в тексте содержатся только буквы и пробельные символы
        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";

        methodText1(text, "it"); //1
        methodText2(text); //2
        methodText3(text); //3
        methodText4(text); //4

    }

    private static Map<String, Customer> someMethod(Map<String, Customer> map, int from, int to) {
        HashMap<String, Customer> newMap = new HashMap<>();
        for (Map.Entry<String, Customer> entry : map.entrySet()) {
            if (entry.getValue().getAge() >= from && entry.getValue().getAge() < to) {
                newMap.put(entry.getKey(), entry.getValue());
            }
        }
        return newMap;

    }

    private static List<String> someMethod2(Map<String, String> map, String city) {
        List<String> loginList = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals(city)) {
                loginList.add(entry.getKey());
            }
        }
        return loginList;
    }

    private static Map<String, Integer> someMethod3(List<String> list) {
        HashMap<String, Integer> newMap = new HashMap<>();
        for (String str : list) {
            newMap.put(str, newMap.getOrDefault(str, 0) + 1);
        }
        return newMap;
    }

    private static void methodText1(String text, String word) {
        text = text.toLowerCase();
        String[] strings = text.split(" ");
        int count = 0;
        for (String s : strings) {
            if (s.equals(word)) count++;
        }
        System.out.println("Слово - \"" + word + "\" встречается в тексте " + count + " раз(а).");
    }

    private static void methodText2(String text) {
        String[] strings = text.split(" ");
        HashMap<Integer, ArrayList<String>> strMap = new HashMap<>();
        for (String s : strings) {
            Integer strSize = s.length();
            if (strMap.containsKey(strSize)) {
                strMap.get(strSize).add(s);
            } else {
                ArrayList<String> tempList = new ArrayList<>();
                tempList.add(s);
                strMap.put(strSize, tempList);
            }
        }
        System.out.println(strMap);
    }

    private static void methodText3(String text) {
        text = text.toLowerCase();
        String[] strings = text.split(" ");
        HashMap<String, Integer> newMap = new HashMap<>();
        for (String str : strings) {
            newMap.put(str, newMap.getOrDefault(str, 0) + 1);
        }
        int maxValue = (Collections.max(newMap.values()));
        int count = 1;
        for (int i = maxValue; i > 0; i--) {
            for (Map.Entry<String, Integer> pair : newMap.entrySet()) {
                if (count > 10) break;
                if (pair.getValue() == i) {
                    System.out.println("" + count + ". Слово - \"" + pair.getKey() + "\" встречается " + pair.getValue() + " раз(а).");
                    count++;
                }
            }
        }
    }

    private static void methodText4(String text) {
        text = text.toLowerCase();
        text = text.replace(" ", "");
        int lengthStr = text.length();
        String[] str = text.split("");
        HashMap<String, Integer> newMap = new HashMap<>();
        for (String s : str) {
           newMap.put(s, newMap.getOrDefault(s, 0) + 1);
        }
        for (Map.Entry<String, Integer> pair : newMap.entrySet()){
          double persent = pair.getValue()/(double) lengthStr * 100;
            System.out.println("Символ \"" + pair.getKey() + "\" " + persent + " %");
        }


    }

}


