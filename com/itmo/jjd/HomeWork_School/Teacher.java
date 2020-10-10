package com.itmo.jjd.HomeWork_School;

public class Teacher extends Human implements TeachAble {
    private SchoolLesson schoolLesson;


    public Teacher(String name, int age, SchoolLesson schoolLesson) {
        super(name, age);
        if (schoolLesson == null) throw new IllegalArgumentException("Школьный предмет не может быть null!");
        this.schoolLesson = schoolLesson;
    }


    public SchoolLesson getSchoolLesson() {
        return schoolLesson;
    }


    @Override
    public void teach(Pupil pupil) {
        pupil.toStudy();
    }
}
