package Lesson5;
/*
Найдите самое длинное слово в предложении, при условии, что в предложении все слова разной длины
Например, в "в предложении все слова разной длины" самое длинное слово "предложении"
 */

public class Lesson5_HomeWork5 {
    public static void main(String[] args) {
        String str = "в предложении все слова разной длины";
        String[] arr = str.split(" ");

        int max = arr[0].length();
        String maxStr = "";

        for (int i = 1; i < arr.length; i++){
            if (arr[i].length() > max){
                max = arr[i].length();
                maxStr = arr[i];
            }
        }
        System.out.println("Самое длинное слово в предложении: " +
                           "\"" + str + "\" - " + "\"" +maxStr + "\"");
    }
}
