package com.itmo.jjd.lesson6.HomeWork2;

public class FoodValue {
    private String name;
    private double protein; //белки
    private double fat; //жиры
    private double carbohydrates; //углеводы
    private double calories; //калорийность

    public FoodValue(String name) {
        setName(name);
        this.name = name;
    }

    public FoodValue(String name, double protein) {
        setName(name);
        setProtein(protein);
        this.protein = protein;
    }

    public FoodValue(String name, double protein, double fat) {
        setName(name);
        setProtein(protein);
        setFat(fat);
        this.fat = fat;
    }

    public FoodValue(String name, double protein, double fat, double carbohydrates) {
        setName(name);
        setProtein(protein);
        setFat(fat);
        this.carbohydrates = carbohydrates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().length() < 2)
            throw new IllegalArgumentException("Наименование д.б. не меньше 2-х символов!");
        this.name = name;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        if (protein < 0) throw new IllegalArgumentException("Содержание белка в продукте не может быть меньше 0!");
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        if (fat < 0) throw new IllegalArgumentException("Жирность продукта не может быть меньше 0!");
        this.fat = fat;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        if (carbohydrates < 0) throw new IllegalArgumentException("Содержание углеводов в продукте не может быть меньше 0!");
        this.carbohydrates = carbohydrates;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        if (calories < 0) throw new IllegalArgumentException("Каллорийность не может быть меньше 0!");
        this.calories = calories;
    }
}
