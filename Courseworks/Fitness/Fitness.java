package Courseworks.Fitness;

import java.time.LocalDate;
import java.time.LocalTime;

public class Fitness extends FitnessConfiguration {

    private SeasonTicket[] tickets_Swim_Pool;
    private SeasonTicket[] tickets_Workout_Room;
    private SeasonTicket[] tickets_Group_Class;

    private String[] zones = new String[3];

    public Fitness() {
        tickets_Swim_Pool = new SeasonTicket[MAX_CLIENT_SWIM_POOL];
        tickets_Workout_Room = new SeasonTicket[MAX_CLIENT_WORKOUT_ROOM];
        tickets_Group_Class = new SeasonTicket[MAX_CLIENT_GROUP_CLASS];
        zones[0] = SWIM_POOL;
        zones[1] = GROUP_CLASS;
        zones[2] = WORKOUT_ROOM;
    }

    public void ticketVerification(String zone, SeasonTicket ticket, LocalDate currentDate, LocalTime currentTime) {
        boolean zoneAccess = false;

        if (!validityDate(ticket, currentDate)) { //проверяем срок действия абонемента
            Logger.invalidDateTimeTicket();
            return;
        }

        for (String z : ticket.allowedZones) { //проверяем доступные зоны для абонемента
            if (z.equals(zone)) {
                zoneAccess = true;
                break;
            }
        }
        if (!zoneAccess) {
            Logger.invalidZone();
            return;
        }

        if (searchTicketInZones(ticket)) { //проверяем не зарегистрирован ли абонемент в других зонах
            Logger.ticketIsAlreadyRegistered();
            return;
        }

        if (!validityTime(ticket, currentTime)) { //проверяем доступное время
            Logger.invalidTimeTicket();
            return;
        }

        if (zone.equals(SWIM_POOL)) {
            for (int i = 0; i < tickets_Swim_Pool.length; i++) {
                if (tickets_Swim_Pool[i] == null) {
                    tickets_Swim_Pool[i] = ticket;
                    Logger.printTicketInfo(ticket, currentDate, currentTime, zone);
                    return;
                }
            }
        }
        if (zone.equals(WORKOUT_ROOM)) {
            for (int i = 0; i < tickets_Workout_Room.length; i++) {
                if (tickets_Workout_Room[i] == null) {
                    tickets_Workout_Room[i] = ticket;
                    Logger.printTicketInfo(ticket, currentDate, currentTime, zone);
                    return;
                }
            }
        }
        if (zone.equals(GROUP_CLASS)) {
            for (int i = 0; i < tickets_Group_Class.length; i++) {
                if (tickets_Group_Class[i] == null) {
                    tickets_Group_Class[i] = ticket;
                    Logger.printTicketInfo(ticket, currentDate, currentTime, zone);
                    return;
                }
            }
        }
       Logger.zoneFull();
    }

    private boolean searchTicketInZones(Ticket ticket) {
        for (Ticket t : tickets_Swim_Pool) {
            if (t == ticket) return true;
        }
        for (Ticket t : tickets_Workout_Room) {
            if (t == ticket) return true;
        }
        for (Ticket t : tickets_Group_Class) {
            if (t == ticket) return true;
        }
        return false;
    }

    private static boolean validityDate(SeasonTicket ticket, LocalDate currentDate) {
        if ((ticket.dateStart.isBefore(currentDate) || ticket.dateStart.isEqual(currentDate))
                && (ticket.dateEnd.isAfter(currentDate) || ticket.dateEnd.isEqual(currentDate))) //проверяем срок действия абонемента
            return true;
        else return false;
    }

    private static boolean validityTime(SeasonTicket ticket, LocalTime currentTime) { //проверяем доступное время
        if ((ticket.timeStart.isBefore(currentTime) || ticket.timeStart.equals(currentTime))
                && (currentTime.isBefore(ticket.timeEnd)))
            return true;
        else return false;
    }

    public void clearZones(LocalTime currentTime) {
        for (int i = 0; i < tickets_Swim_Pool.length; i++) {
            if (tickets_Swim_Pool[i] != null && !validityTime(tickets_Swim_Pool[i], currentTime)) {
                tickets_Swim_Pool[i] = null;
            }
        }
        for (int i = 0; i < tickets_Workout_Room.length; i++) {
            if (tickets_Workout_Room[i] != null && !validityTime(tickets_Workout_Room[i], currentTime)) {
                tickets_Workout_Room[i] = null;
            }
        }
        for (int i = 0; i < tickets_Group_Class.length; i++) {
            if (tickets_Group_Class[i] != null && !validityTime(tickets_Group_Class[i], currentTime)) {
                tickets_Group_Class[i] = null;
            }
        }
    }

    public void printInfoFitness() {
        System.out.println("\nТренажерный зал:");
        for (SeasonTicket t : tickets_Workout_Room) {
            if (t != null) Logger.printFinnessZoneInfo(t);
        }
        System.out.println("\nБассейн:");
        for (SeasonTicket t : tickets_Swim_Pool) {
            if (t != null) Logger.printFinnessZoneInfo(t);
        }
        System.out.println("\nГрупповые занятия:");
        for (SeasonTicket t : tickets_Group_Class) {
            if (t != null) Logger.printFinnessZoneInfo(t);
        }
    }
}
