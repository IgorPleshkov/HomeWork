package com.itmo.jjd.lesson7;

public class Infantry extends BattleUnit { //пехотинец

    public Infantry(int healthPoint, int agilityPoints, int attackPoints) {
        super(healthPoint, agilityPoints, attackPoints);
    }

    //реализация метода attack(BattleUnit unit) интерфейса AttackAble
    @Override
    public void attack(BattleUnit unit) {
        if (this.isAlive() && unit.isAlive() && unit.agilityPoints  <= this.agilityPoints){
          unit.minusHealth(this.attackPoints);
        }
        if (unit.isAlive() && this.isAlive() && unit.agilityPoints >= this.agilityPoints){
            this.minusHealth(unit.attackPoints);
        }
       // if (unit.isAlive() && unit.)
    }
    //реализация метода rest() интерфейса RestAble
    @Override
    public void rest() {
      this.plusHealth(2);
    }
}
