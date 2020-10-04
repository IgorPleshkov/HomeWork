package Lesson5;
/*
Задать массив на N слов.
В цикле считывать с консоли слова (scanner.nextLine()), и добавлять их в массив
(добавлять новое слово в массив можно только, если в нем его еще нет).
В итоге в массиве будут только уникальные слова.
Выход их программы по слову exit (его в массив не добавлять) или если массив заполнен
Перед завершением программы, вывести получившийся массив в консоль.
*/

import java.util.Arrays;
import java.util.Scanner;

public class Lesson5_HomeWork1 {
    public static void main(String[] args) {
        int arrLength = 10;
        String[] arr = new String[arrLength];
        Scanner scanner = new Scanner(System.in);
        boolean strIsFound;

        System.out.println("Введите " + arrLength + " cлов в консоль. Повторяющиеся слова не учитываются. \nПосле ввода " +
                           "каждого слова нажать Enter. \nДля выхода из программы ввести \"exit\"");
        for (int i = 0; i < arr.length; i++) {
            String str = scanner.nextLine();
            strIsFound = false;
            if (str.equals("exit")) {
                break;
            }
            for (String s : arr) {
                if (str.equals(s)) {
                    i--;  //для заполнения массива без пропусков (null)
                    strIsFound = true;
                    break;
                }
            }
            if (!strIsFound) arr[i] = str;
        }
        System.out.println(Arrays.toString(arr));
    }
}
