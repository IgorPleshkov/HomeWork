package com.itmo.jjd.lesson6;

import java.util.Arrays;

public class ColouringShelf {
    private ColouringBook[] colouring;
    private String color = "красный";

    // конструктор
    public ColouringShelf(int count) {
        if (count < 10)
            throw new IllegalArgumentException("count не должен быть менее 10");
        colouring = new ColouringBook[count];
    }

    // конструктор
    public ColouringShelf(int count, String color) {
        this(count); // вызов конструктора
        setColor(color);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color == null || color.trim().length() < 3)
            throw new IllegalArgumentException("color не должен быть менее 3");
        this.color = color;
    }

    // return в void методах используется только! для того, чтобы прервать его работу
    public void addColouring(ColouringBook book){
        for (int i = 0; i < colouring.length; i++) {
            if (colouring[i] == null) {
                colouring[i] = book;
                return;
            }
        }
    }

    public void addColouring(ColouringBook... books){
        //System.out.println(Arrays.toString(books));
        int count = 0;
        for (int i = 0; i < colouring.length; i++) {
            if (colouring[i] == null && count < books.length) {
                    colouring[i] = books[count];
                    count++;

            }
        }
        if (count != books.length){
            System.out.println("Данные книги не поместились в шкаф: ");
            StringBuilder sb = new StringBuilder();
            for (int i = count; i < books.length; i++){
               sb.append(books[i].getTitle()).append("\n");
            }
            System.out.println(sb.toString());
        }
    }

    public String getBooksInfo(){
        StringBuilder sb = new StringBuilder();
        for (ColouringBook book : colouring) {
            if (book != null)
                sb.append(book.getTitle())
                        .append(" ")
                        .append(book.getPageCount())
                        .append("\n");
        }
        return sb.toString();
    }

    // public void getBooksInfo() { }



    @Override
    public String toString() {
        return "ColouringShelf{" +
                "colouring=" + Arrays.toString(colouring) +
                ", color='" + color + '\'' +
                '}';
    }
}