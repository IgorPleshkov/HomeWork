package com.itmo.jjd.HomeWork_School;

public class Director extends Human{
    private boolean startLesson;

    public Director(String name, int age) {
        super(name, age);
    }

    public boolean isStartLesson() {
        return startLesson;
    }

    public void startLesson(){
        this.startLesson = true;
    }
    public void stopLesson(){
        this.startLesson = false;
    }
}
