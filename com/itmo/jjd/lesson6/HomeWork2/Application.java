package com.itmo.jjd.lesson6.HomeWork2;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        FoodValue milk = new FoodValue("Молоко",12.0,7.0, 21.0);
        milk.setCalories(70.0);

        FoodValue bread = new FoodValue("Хлеб",15.0,4.0, 17.0);
        bread.setCalories(75.0);

        FoodValue meat = new FoodValue("Мясо",30.0,8.0, 25.0);
        meat.setCalories(88.0);

        FoodValue cheese = new FoodValue("Сыр",40.0,9.0, 20.0);
        cheese.setCalories(63.0);


        MyFood myFood = new MyFood(10,40.0, 50.0, 30.0, 100.0);

        myFood.addFood(milk, bread, meat, cheese);

        System.out.println(myFood.myFoodInfo());

        }
    }

