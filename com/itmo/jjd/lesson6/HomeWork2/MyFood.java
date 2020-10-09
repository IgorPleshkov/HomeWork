package com.itmo.jjd.lesson6.HomeWork2;

public class MyFood {
    private FoodValue[] arrFood;
    private double maxProtein;//максимальное количество белков
    private double maxFat; //максимальное количество жиров
    private double maxCarbohydrates; //максимальное количество углеводов
    private double maxCalories; //максимальная калорийность

    public MyFood(int count, double maxProtein, double maxFat, double maxCarbohydrates, double maxCalories) {
        if (maxProtein < 0 || maxFat < 0 || maxCarbohydrates < 0 || maxCalories < 0)
            throw new IllegalArgumentException("Некоторые характеристики меньше 0!");
        this.maxProtein = maxProtein;
        this.maxFat = maxFat;
        this.maxCarbohydrates = maxCarbohydrates;
        this.maxCalories = maxCalories;
        arrFood = new FoodValue[count];
    }


    public void addFood(FoodValue... food){
        int count = 0;
        int addCount = 0;
       for (int i = 0; i < arrFood.length; i++){
           if (arrFood[i] == null && count < food.length){
               String foodName = food[count].getName();
               if (food[count].getProtein() > maxProtein) {
                   System.out.println("Превышение содержания белков в продукте: " + foodName);
                   count++;
                   continue;
               }
               if (food[count].getFat() > maxFat) {
                   System.out.println("Превышение содержания жиров в продукте: " + foodName);
                   count++;
                   continue;
               }
               if (food[count].getCalories() > maxCalories) {
                   System.out.println("Слишком высокая каллорийность в продукте: " + foodName);
                   count++;
                   continue;
               }
               if (food[count].getCarbohydrates() > maxCarbohydrates) {
                   System.out.println("Превышение содержания углеводов в продукте: " + foodName);
                   count++;
                   continue;
               }
               arrFood[i] = food[count];
               count++;
               addCount++;
           }

           }

        if (addCount != food.length){
            System.out.println("Не все продукты добавлены!");
       }
    }

    public String myFoodInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Состав продуктовой корзины:\n");
        for (FoodValue str : arrFood){
            if (str != null) {
                sb.append(str.getName()).append(" :: ").
                        append(" Белки: ").
                        append(str.getProtein()).
                        append(" Жиры: ").
                        append(str.getFat()).
                        append(" Углеводы: ").
                        append(str.getCarbohydrates()).
                        append(" Каллорийность: ").
                        append(str.getCalories()).
                        append("\n");
            }
        }
        return sb.toString();
    }
}
