package Lesson5;
/*
Написать функцию, которая проверяет, является ли строка палиндромом.
Палиндром — это число, буквосочетание, слово или текст, которые одинаково читаются по буквам или по словам как слева направо, так и справа налево.
Например, 202 - палиндром / fafaf - палиндром / а роза упала на лапу Азора - палиндром
*/

public class Lesson5_HomeWork3 {
    public static void main(String[] args) {

        String str = "а роза упала на лапу Азора";
        String str1 = str.replaceAll(" ", ""); //удалим все пробелы из строки
        str1 = str1.toLowerCase(); //регистр не учитываем
        Boolean isPalindrom = true;

        for (int i = 0; i < str1.length()/2; i++){
            if (str1.charAt(i) != str1.charAt(str1.length()-i-1)){
                isPalindrom = false;
                break;
            }
        }
        System.out.println("Строка: " + "\"" + str + "\"" + (isPalindrom ? " - это палиндром." : " - это не палиндром."));
    }
}
