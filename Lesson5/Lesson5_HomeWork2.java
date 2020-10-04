package Lesson5;
/*
Найти количество вхождений одной строки в другую.
Например, строка "дом" встречается в строке "дом домик домой одомашненный" 4 раза
 */

public class Lesson5_HomeWork2 {
    public static void main(String[] args) {
        String str1 = "дом";
        String str2 = "дом домик домой одомашненный Домовой  придомовая ДОМ";
        int count = 0; //счетчик

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase(); //регистр не учитываем

        for (int i = 0; i < str2.length(); i++) {
            if (str2.startsWith(str1, i)) {
                count++;
                i += str1.length() - 1; //для сокращения кол-ва итераций
            }
        }
        System.out.println("Количество вхождений строки " + "\"" + str1 + "\"" + " в сроку: " + "\n\"" + str2 + "\"" +
                           "\n - составляет " + count + " раз(а).");
    }
}
