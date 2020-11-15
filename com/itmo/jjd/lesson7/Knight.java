package com.itmo.jjd.lesson7;

public class Knight extends BattleUnit{ //рыцарь

    private final int additionalAttack = 2; //дополнительная атака

    public Knight(int healthPoint, int agilityPoints, int attackPoints) {
        super(healthPoint, agilityPoints, attackPoints);
    }

    @Override
    public void attack(BattleUnit unit) {
     if (this.isAlive() && unit.isAlive() && unit.agilityPoints < this.agilityPoints){
         unit.minusHealth(this.attackPoints+agilityPoints);
     }
     if (unit.isAlive() && this.isAlive() && unit.agilityPoints > this.agilityPoints){
         this.minusHealth(unit.attackPoints);
     }
    }

    @Override
    public void rest() {
      plusHealth(3);
    }
}

//наследование
//как вызываются методы, какие методы кому достаются
