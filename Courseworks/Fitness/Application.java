package Courseworks.Fitness;

import java.time.LocalDate;
import java.time.LocalTime;

public class Application {
    public static void main(String[] args) {
        Client client1 = new Client("Иван", "Иванов", "1985-05-11");
        Client client2 = new Client("Николай", "Николаев", "1981-09-21");
        Client client3 = new Client("Андрей", "Андреев", "1985-05-12");
        Client client4 = new Client("Павел", "Павлов", "1969-07-22");

        SeasonTicket ticket1 = new SeasonTicket(1,"2020-10-18", "2021-04-17", client1);
        SeasonTicket ticket2 = new SeasonTicket(2,"2020-10-17", "2021-11-17", client2);
        SeasonTicket ticket3 = new SeasonTicket(3,"2020-10-18", "2020-10-18", client3);
        SeasonTicket ticket4 = new SeasonTicket(1,"2020-10-18", "2021-10-18", client4);

        LocalDate currentDate = LocalDate.of(2020, 10, 18); //
        LocalTime currentTime = LocalTime.of(8, 0, 0);

        Fitness fitness = new Fitness();

        fitness.clearZones(currentTime);

        fitness.ticketVerification(FitnessConfiguration.SWIM_POOL, ticket1, currentDate, currentTime);
        fitness.ticketVerification(FitnessConfiguration.GROUP_CLASS, ticket2, currentDate, currentTime);
        fitness.ticketVerification(FitnessConfiguration.WORKOUT_ROOM, ticket3, currentDate, currentTime);
        fitness.ticketVerification(FitnessConfiguration.WORKOUT_ROOM, ticket4, currentDate, currentTime);

        fitness.printInfoFitness();
        }
    }

