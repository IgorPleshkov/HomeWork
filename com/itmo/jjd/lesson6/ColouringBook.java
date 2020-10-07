package com.itmo.jjd.lesson6;
// имя public класса должно соответствовать имени файла
// в файле может быть только один public класс
// название
// количество картинок
// автор (имя, фамилия)
public class ColouringBook {
    // свойства / поля / атрибуры
    private String title; // название, значение по умолчанию null
    private int pageCount; // название, значение по умолчанию 0
    private Author author; // автор, значение по умолчанию null
    // значение свойств по умолчанию:
    // boolean: false
    // целочисленные типы: 0
    // числа с плавающей точкой: 0.0
    // char: u0000
    // ссылочные типы: null

    // модификаторы доступа:
    // private - доступны только в рамках класса
    // public - доступны из любого участка программы
    // package-private/default (если не установлен) - доступны в рамках пакета
    // protected - доступны в рамках пакета / в рамках дочерних классов

    // сеттер - метод, которые позволит выполнить проверку входящих
    // данных и установить значение свойства объекта (если проверки пройдены)
    // public - модификатор доступа
    // void метод выполняет действие и не возвращает результат
    // setTitle - имя метода должно отражать то, что происходит в методе
    // (String title) - аргументы метода, принимает на вход объект типа String
    public void setTitle(String title){
        if ( title == null || title.trim().length() < 3)
            throw new IllegalArgumentException("title должен быть не меньше 3");
        // присваиваем значение свойства title равное (String title)
        // this - ссылка на текущий объект
        // (this можно не использовать, если имя аргумента отличается от
        // название свойства)
        this.title = title;
    }
    // геттер - метод, который возвращает значение свойства
    // public - модификатор доступа
    // String - тип возвращаемого значения
    // getTitle - имя метода
    // () - без аргументов
    public String getTitle(){
        // return прерывает рабату метода
        //        возвращает результат работы метода
        return title;
    }

    // Alt + Insert / правой кнопкой -> Generate
    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        if (pageCount < 5)
            throw new IllegalArgumentException("pageCount должно быть не меньше 5");
        this.pageCount = pageCount;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        if (author == null)
            throw new IllegalArgumentException("author не должен быть null");
        this.author = author;
    }

    @Override
    public String toString() {
        return "ColouringBook{" +
                "title='" + title + '\'' +
                ", pageCount=" + pageCount +
                ", author=" + author +
                '}';
    }
}

// класс {
//     свойства
//     конструкторы
//     геттеры + сеттеры
//     методы
//     переопределенные методы
// }