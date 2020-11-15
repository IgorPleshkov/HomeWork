package com.itmo.jjd.lesson7;

public interface AttackAble { //атака
    //метод без реализации
    void attack(BattleUnit unit);

    //метод с реализацией
    default void run(){
        System.out.println("run AttackAble");
    }
}
