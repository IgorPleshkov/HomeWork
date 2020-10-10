package com.itmo.jjd.HomeWork_School;

public class School {
    private String name;
    private Director director;
    private Teacher[] teachers;
    private Pupil[] pupils;

    public School(String name, int sizeTeacher, int sizePupils) {
        if (sizeTeacher < 1) throw new IllegalArgumentException("Должен быть хотя бы один учитель!");
        if (sizePupils < 1) throw new IllegalArgumentException("Должен быть хотя бы один ученик!");
        this.name = name;
        //this.director = director;
        teachers = new Teacher[sizeTeacher];
        pupils = new Pupil[sizePupils];
    }

    public void setDirector(Director director) {
        if (director == null) throw new IllegalArgumentException("Директор не может быть null!");
        this.director = director;
    }

    public void addTeacher(Teacher... teacher) {
        int count = 0;
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] == null && count < teacher.length) {
                teachers[i] = teacher[count];
                count++;
            }
        }
    }

    public void addPupil(Pupil... pupil) {
        int count = 0;
        for (int i = 0; i < pupils.length; i++) {
            if (pupils[i] == null && count < pupil.length) {
                pupils[i] = pupil[count];
                count++;
            }
        }
    }

    public void schoolDay() {
        director.startLesson();
        if (!director.isStartLesson()) {
            System.out.println("начало занятий еще не объявлено!");
            return;
        }
        for (Teacher teacher : teachers) {
            if (teacher != null) {
                for (Pupil pupil : pupils) {
                    if (pupil != null) {
                        if (teacher.getSchoolLesson() == pupil.getSchoolLesson()) {
                            teacher.teach(pupil);
                        }
                    }
                }
            }
        }
        director.stopLesson();
    }

    public String schoolInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(", Директор: ").append(director.name).append("\n");
        sb.append("Учителя школы:\n");
        for (Teacher teacher : teachers) {
            if (teacher == null) break;
            sb.append(teacher.name).
                    append(", Возраст: ").append(teacher.age).
                    append(", Преподаваемый предмет: ").
                    append(teacher.getSchoolLesson().getNameSchoolLesson()).
                    append("\n");

        }
        sb.append("Ученики:\n");
        for (Pupil pupil : pupils) {
            if (pupil == null) break;
            sb.append(pupil.name).
                    append(", Возраст: ").
                    append(pupil.age).
                    append(", Уровень знаний: ").
                    append(pupil.getKnowledgeLevel()).
                    append(", Изучаемый предмет: ").
                    append(pupil.getSchoolLesson().getNameSchoolLesson()).
                    append("\n");
        }
        return sb.toString();
    }
}
