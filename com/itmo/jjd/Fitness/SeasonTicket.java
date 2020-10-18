package com.itmo.jjd.Fitness;

import java.time.LocalTime;

import com.itmo.jjd.Fitness.FitnessConfiguration;

public class SeasonTicket extends Ticket {

    private int typeTicket;

    public SeasonTicket(int typeTicket, String dateStart, String dateEnd, Client client) {
        super(dateStart, dateEnd, client);
        if (typeTicket < 1 || typeTicket > 3) throw new IllegalArgumentException("Тип абонемента д.б. 1-3!");
        this.typeTicket = typeTicket;
        allowedZones = FitnessConfiguration.setAllowedZones(typeTicket);
        timeStart = FitnessConfiguration.setTimeStart(typeTicket);
        timeEnd = FitnessConfiguration.setTimeEnd(typeTicket);
        if (typeTicket == 3) super.dateEnd = super.dateStart; // разовый абонемент
    }
}

