package com.itmo.jjd.HomeWork_School;

public class Application {
    public static void main(String[] args) {

        School school = new School("Школа №333", 10, 100);
        Director director = new Director("Иван Иванович", 56);
        school.setDirector(director);

        SchoolLesson mathematics = new SchoolLesson("Математика");
        SchoolLesson literature = new SchoolLesson("Литература");
        SchoolLesson physics = new SchoolLesson("Физика");

        Teacher teacherMath = new Teacher("Мария Ивановна", 52, mathematics);
        Teacher teacherLit = new Teacher("Лариса Васильевна", 44, literature);
        Teacher teacherPhys = new Teacher("Василий Михайлович", 49, physics);

        Pupil pupil1 = new Pupil("Вася", 12, 3, mathematics);
        Pupil pupil2 = new Pupil("Петя", 13, 5, literature);
        Pupil pupil3 = new Pupil("Коля", 14, 8, physics);

        school.addTeacher(teacherMath, teacherLit, teacherPhys);
        school.addPupil(pupil1, pupil2, pupil3);


        for (int i = 0; i < 5; i++) { //неделя занятий
            school.schoolDay();
        }

        System.out.println(school.schoolInfo());


    }
}
