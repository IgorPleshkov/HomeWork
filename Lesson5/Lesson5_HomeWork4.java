package Lesson5;

/*
Заменить все буквы в слове на строчные, а первую букву на заглавную
Например, дано hello, получаем Hello / дано HeLLO, получаем Hello
 */

public class Lesson5_HomeWork4 {
    public static void main(String[] args) {
        String str = "heLLo";
        str = str.toLowerCase(); //переводим всю строку в нижний регистр
        str = str.substring(0, 1).toUpperCase() + str.substring(1); //получаем символ с индекса 0 до индекса 1 ("h")
                                                                    //переводим ее в верхний регистр
                                                                    //присоединяем остаток строки (с индекса 1 до конца строки)

        System.out.println(str);
    }
}
