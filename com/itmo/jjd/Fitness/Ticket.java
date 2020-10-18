package com.itmo.jjd.Fitness;

import java.time.LocalDate;
import java.time.LocalTime;

abstract public class Ticket {

    protected LocalDate dateStart;
    protected LocalDate dateEnd;
    protected Client client;

    protected String[] allowedZones;
    protected LocalTime timeStart;
    protected LocalTime timeEnd;

    public Ticket(String dateStart, String dateEnd, Client client) {
        if (!IsValidDate.isValidDate(dateStart))
            throw new IllegalArgumentException("Неправильный формат даты начала действия абонемента!");
        if (!IsValidDate.isValidDate(dateEnd))
            throw new IllegalArgumentException("Неправильный формат даты окончания действия абонемента!");
        if (client == null) throw new IllegalArgumentException("Клиент не д.б. null!");
        this.dateStart = LocalDate.parse(dateStart);
        this.dateEnd = LocalDate.parse(dateEnd);
        this.client = client;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public Client getClient() {
        return client;
    }
}
