package Home_work.Enums.HomeWork1;

import java.util.Objects;

public class Personnel {
    private User[] cashier = new User[10];
    private User[] accountant = new User[10];
    private User[] manager = new User[10];
    private User[] director = new User[10];

    public void addUser(User user, Position position) {
        boolean success = false;
        if (position.equals(Position.CASHIER)) {
            for (int i = 0; i < cashier.length; i++) {
                if (Objects.isNull(cashier[i])){
                    cashier[i] = user;
                    success = true;
                    break;
                }
            }
        }
        if (position.equals(Position.MANAGER)) {
            for (int i = 0; i < manager.length; i++) {
                if (Objects.isNull(manager[i])) {
                    manager[i] = user;
                    success = true;
                    break;
                }
            }
        }
        if (position.equals(Position.ACCOUNTANT)) {
            for (int i = 0; i < accountant.length; i++) {
                if (Objects.isNull(accountant[i])) {
                    accountant[i] = user;
                    success = true;
                    break;
                }
            }
        }
        if (position.equals(Position.DIRECTOR)) {
            for (int i = 0; i < director.length; i++) {
                if (Objects.isNull(director[i])) {
                    director[i] = user;
                    success = true;
                    break;
                }

            }
        }
        if (!success) System.out.println("На должность - " + position + " все ставки заняты!");
    }
    //-------
    public void personnelInfo() {
        System.out.println("\nКассиры:");
        for (User u : cashier){
            if (!Objects.isNull(u)) System.out.println(u.toString());
        }
        System.out.println("\nМенеджеры:");
        for (User u : manager){
            if (!Objects.isNull(u)) System.out.println(u.toString());
        }
        System.out.println("\nБухгалтеры:");
        for (User u : accountant){
            if (!Objects.isNull(u)) System.out.println(u.toString());
        }
        System.out.println("\nДиректора:");
        for (User u : director){
            if (!Objects.isNull(u)) System.out.println(u.toString());
        }
    }
}
