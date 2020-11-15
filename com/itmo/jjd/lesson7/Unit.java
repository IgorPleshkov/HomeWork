package com.itmo.jjd.lesson7;
//класс Unit имплементирует интерфейс RestAble, соответственно обязан
//реализовать все методы без реализации данного интерфейса
//либо класс должен быть abstract

//abstract могут содержать методы без реализации
//abstract могут содержать методы с реализацией
//на основе abstract класса нельзя создавать объекты

import java.io.Serializable;

abstract public class Unit implements RestAble, Serializable {
    protected int healthPoint; //здоровье
    protected int agilityPoints; //ловкость

    protected final int maxHealth; //максимальный уровень здоровья

    public Unit(int healthPoint, int agilityPoints) {
        if (healthPoint <= 0 && agilityPoints <= 0){
            throw new IllegalArgumentException("healthPoint <= 0 && agilityPoints <= 0");
        }
        maxHealth = healthPoint;
        this.healthPoint = healthPoint;
        this.agilityPoints = agilityPoints;
    }

    public void plusHealth(int points){  //увеличение здоровья
        if (isAlive()){
            healthPoint += points;
            if (healthPoint > maxHealth){
                healthPoint = maxHealth;
            }
        }
    }

    public void minusHealth(int points){ //уменьшение здоровья
        if (isAlive()){
            healthPoint -= points;
            if (healthPoint < 0){
                healthPoint = 0;
            }
        }

    }

    public boolean isAlive(){ //проверка жив или нет
        return healthPoint > 0;
    }
}
