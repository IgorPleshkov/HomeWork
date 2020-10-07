package com.itmo.jjd.lesson6.HomeWork1;

public class Application {
    public static void main(String[] args) {
        Mountain mountain1 = new Mountain("Эльбрус", "Россия", 5642);
        Mountain mountain2 = new Mountain("Арарат", "Турция", 5137);
        Mountain mountain3 = new Mountain("Эверест", "Непал", 8848);

        Alpinist alpinist1 = new Alpinist("Василий", "ул. Советская 11");
        Alpinist alpinist2 = new Alpinist("Петр", "ул. Строителей 3");
        Alpinist alpinist3 = new Alpinist("Николай", "ул. Чайковского 12");
        Alpinist alpinist4 = new Alpinist("Иван", "ул. Прибрежная 9");
        Alpinist alpinist5 = new Alpinist("Павел", "ул. Гороховая 14");
        Alpinist alpinist6 = new Alpinist("Владимир", "ул. Бехтерева 4");
        Alpinist alpinist7 = new Alpinist("Максим", "ул. Полевая 2");


        AlpinistGroup group1 = new AlpinistGroup(3, mountain1);
        AlpinistGroup group2 = new AlpinistGroup(2, mountain2);
        AlpinistGroup group3 = new AlpinistGroup(2, mountain3);

        group1.addAlpinist(alpinist1);
        group1.addAlpinist(alpinist2);
        group1.addAlpinist(alpinist3);

        group1.setGroupIsCompleted(true); //закрываем набор в группу1

        group2.addAlpinist(alpinist4);
        group2.addAlpinist(alpinist5);

        group2.setGroupIsCompleted(true); //закрываем набор в группу2

        group3.addAlpinist(alpinist6);
        group3.addAlpinist(alpinist7);

        group3.setGroupIsCompleted(true); //закрываем набор в группу3


        System.out.println(group1.groupInfo());
        System.out.println(group2.groupInfo());
        System.out.println(group3.groupInfo());






    }
}
