package com.itmo.jjd.Fitness;

import java.time.LocalTime;

abstract public class FitnessConfiguration {
    public static final String SWIM_POOL = "Бассейн";
    public static final String WORKOUT_ROOM = "Тренажерный зал";
    public static final String GROUP_CLASS = "Групповые занятия";

    public static final int MAX_CLIENT_SWIM_POOL = 20;
    public static final int MAX_CLIENT_WORKOUT_ROOM = 20;
    public static final int MAX_CLIENT_GROUP_CLASS = 20;

    public static final int fullTicket = 1;
    public static final int dayTicket = 2;
    public static final int singleTicket = 3;


    public static String[] setAllowedZones(int typeTicket) {
        String[] zones = new String[0];
        switch (typeTicket) {
            case fullTicket:
                zones = new String[3];
                zones[0] = SWIM_POOL;
                zones[1] = WORKOUT_ROOM;
                zones[2] = GROUP_CLASS;
                break;
            case dayTicket:
                zones = new String[2];
                zones[0] = WORKOUT_ROOM;
                zones[1] = GROUP_CLASS;
                break;
            case singleTicket:
                zones = new String[2];
                zones[0] = WORKOUT_ROOM;
                zones[1] = SWIM_POOL;
                break;
            default:
                Logger.invalidTypeTicket();
                break;
        }
        return zones;
    }

    public static LocalTime setTimeStart(int typeTicket) {
        LocalTime time = LocalTime.of(0, 0, 0);
        switch (typeTicket) {
            case fullTicket:
                time = LocalTime.of(8, 0, 0);
                break;
            case dayTicket:
                time = LocalTime.of(8, 0, 0);
                break;
            case singleTicket:
                time = LocalTime.of(8, 0, 0);
                break;
            default:
                Logger.invalidTypeTicket();
                break;
        }
        return time;
    }

    public static LocalTime setTimeEnd(int typeTicket) {
        LocalTime time = LocalTime.of(0, 0, 0);
        switch (typeTicket) {
            case fullTicket:
                time = LocalTime.of(22, 0, 0);
                break;
            case dayTicket:
                time = LocalTime.of(16, 0, 0);
                break;
            case singleTicket:
                time = LocalTime.of(22, 0, 0);
                break;
            default:
                Logger.invalidTypeTicket();
                break;

        }
        return time;
    }
}
