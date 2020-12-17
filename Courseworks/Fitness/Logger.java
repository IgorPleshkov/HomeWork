package Courseworks.Fitness;

import java.time.LocalDate;
import java.time.LocalTime;

abstract public class Logger {

    public static void clientInfo(Client client) {
        System.out.println(client.toString());
    }

    public static void invalidTypeTicket() {
        System.out.println("Не правильно указан тип абонемента!");
    }

    public static void ticketIsAlreadyRegistered() {
        System.out.println("Данный абонемент сегодня уже зарегистрирован!");
    }

    public static void invalidDateTimeTicket() {
        System.out.println("Абонемент недействителен!");
    }

    public static void invalidTimeTicket() {
        System.out.println("Абонементу не доступно данное время!");
    }

    public static void invalidZone() {
        System.out.println("Данная зона недоступна по данному абонементу!");
    }

    public static void zoneFull() {
        System.out.println("В данной зоне нет свободных мест!");
    }

    public static void printTicketInfo(SeasonTicket ticket, LocalDate date, LocalTime time, String zone) {
        StringBuilder sb = new StringBuilder();
        sb.append("Клиент: ").
                append(ticket.getClient().toString()).
                append(" Дата посещения: ").
                append(date.toString()).
                append(" Время посещения: ").
                append(time.toString()).
                append(" Посещаемая зона: ").
                append(zone);

        System.out.println(sb.toString());
    }

    public static void printFinnessZoneInfo(SeasonTicket ticket) {
        StringBuilder sb = new StringBuilder();
        sb.append("Клиент: ").
                append(ticket.getClient().toString());
        System.out.println(sb.toString());
    }


}
