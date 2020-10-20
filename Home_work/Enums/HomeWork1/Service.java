package Home_work.Enums.HomeWork1;

import java.util.Objects;
import java.util.Scanner;

public class Service {
    private static Position returnPosition(String str){
        Position[] positions = Position.values();
        str = str.substring(0, 1);
        for (int i = 0; i < positions.length; i++){
            String str2 = positions[i].toString().substring(0, 1);
            if (str2.toLowerCase().equals(str.toLowerCase())) return positions[i];
        }
        return null;
    }

    public static User createUser (String str){
        String[] arrStr = str.split(" ");
        if (arrStr.length < 3) {
            System.out.println("Данные введены не корректно!");
            return null;
        }

        String name = arrStr[0];
        String surname = arrStr[1];
        String pos = arrStr[2];

       User user = new User(name + " " + surname, returnPosition(pos));
       return user;
    }

    public static void startProgramm(){
        Scanner scanner = new Scanner(System.in);
        Personnel personnel = new Personnel();
        while (true) {
            System.out.println("Введите через пробел Имя Фамилию и первую букву должности " +
                    "латиницей:" +
                    "\nс - кассир, m - менеджер, a - бухгалтер, d - директор " +
                    "\nдля выхода ввести exit:");
            String str = scanner.nextLine();
            if (str.equals("exit")) break;
            User user = Service.createUser(str);
            if (Objects.isNull(user)) continue;
            personnel.addUser(user, user.getPosition());
        }
        personnel.personnelInfo();
    }
}
