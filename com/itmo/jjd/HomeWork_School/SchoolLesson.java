package com.itmo.jjd.HomeWork_School;

public class SchoolLesson {
    private String nameSchoolLesson;

    public SchoolLesson(String nameSchoolLesson) {
        if (nameSchoolLesson == null || nameSchoolLesson.trim().length() < 3)
            throw new IllegalArgumentException("Наименование школьного предмета не может быть меньше 3-х символов!");
        this.nameSchoolLesson = nameSchoolLesson;
    }

    public String getNameSchoolLesson() {
        return nameSchoolLesson;
    }
}

