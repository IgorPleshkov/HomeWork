package com.itmo.jjd.HomeWork_School;

abstract public class Human {
    protected String name;
    protected int age;

    public Human(String name, int age) {
        if (name == null || name.trim().length() < 2)
            throw new IllegalArgumentException("Имя не может быть меньше 2-х символов!");
        if (age < 6) throw new IllegalArgumentException("Слишком молодой!");
        if (age > 90) throw new IllegalArgumentException("Слишком старый!");
        this.name = name;
        this.age = age;
    }
}
