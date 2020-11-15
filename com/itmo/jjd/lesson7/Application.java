package com.itmo.jjd.lesson7;

import com.itmo.jjd.Lesson20.Serialization.ObjectFromFile;

import java.io.File;

public class Application {
    public static void main(String[] args) {
        King king1 = new King(100, 10);
        King king2 = new King(100, 15);

        king1.generateArmy();
        king2.generateArmy();

        king1.startAttack(king2);

        File file = new File("King.bin");
        ObjectToFile.objectToFile(file, king1);
        King kingFromFile = (King)ObjectFromFile.objectFromFile(file);
        System.out.println("King from file: " + kingFromFile.getAttackResult());

        king2.startAttack(king1);

        System.out.println(king1.getAttackResult());
        System.out.println(king2.getAttackResult());

        king1.addUnits();
        System.out.println(king1.getAttackResult());


    }
}
