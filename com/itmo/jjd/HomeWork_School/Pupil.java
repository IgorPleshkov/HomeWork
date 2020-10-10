package com.itmo.jjd.HomeWork_School;

public class Pupil extends Human implements ToStudyAble {
    private int knowledgeLevel;
    private SchoolLesson schoolLesson;


    public Pupil(String name, int age, int knowledgeLevel, SchoolLesson schoolLesson) {
        super(name, age);
        if (knowledgeLevel < 0) throw new IllegalArgumentException("Уровень знаний не может быть меньше 0!");
        if (schoolLesson == null) throw new IllegalArgumentException("Школьный предмет не может быть null!");
        this.knowledgeLevel = knowledgeLevel;
        this.schoolLesson = schoolLesson;
    }

    public int getKnowledgeLevel() {
        return knowledgeLevel;
    }

    public SchoolLesson getSchoolLesson() {
        return schoolLesson;
    }

    @Override
    public void toStudy() {
        knowledgeLevel++;
    }

}
