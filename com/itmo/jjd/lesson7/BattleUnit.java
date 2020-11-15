package com.itmo.jjd.lesson7;

// extends - наследование (множественное наследование запрещено)
// Класс BattleUnit наследуется от класса Unit
// класс BattleUnit - дочерний клас
// класс Unit - родительский класс
// Дочерний класс получает доступ ко всем доступным свойствам и методам родительского класса

abstract  public class BattleUnit extends Unit implements AttackAble{ //боевой юнит
    protected int attackPoints;

    //мы обязаны вызвать конструктор родителя (поскольку у родителя нет конструктора без параметров)
    //необходимо обратиться к минимум одному конструктору родителю //super
    public BattleUnit(int healthPoint, int agilityPoints, int attackPoints) {
        super(healthPoint, agilityPoints);
        if (attackPoints <= 0) {
            throw new IllegalArgumentException("attackPoints < = 0");
        }
        this.attackPoints = attackPoints;
    }
    //класс battleUnit реализует (имплементирует) интерфейс
    //RestAble и AttackAble, в которых есть методы run с реализацией
    //В такой ситуации мы обязаны явно указать, какой метод выбрать
    @Override
    public void run() {
        System.out.println("Реализация run BattleUnit");
    }

    //
    public static BattleUnit unitFactory(){
        String[] types = {"knight", "infantry"};
        BattleUnit unit = null;
        switch (types[(int) (Math.random() * types.length)]){
            case "knight":
                unit = new Knight(
                        (int) (Math.random() * 41) + 10,
                        (int) (Math.random() * 11) + 5,
                        (int) (Math.random() * 11) + 8
                );
                break;
            case "infantry":
                unit = new Infantry(
                        (int) (Math.random() * 41) + 20,
                        (int) (Math.random() * 11) + 5,
                        (int) (Math.random() * 11) + 5
                );
                break;
        }
        return unit;
    }
}
