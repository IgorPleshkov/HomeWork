package Courseworks.Game;

import Courseworks.Game.command.*;

import java.util.Map;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        ReceiverCommand command = new ReceiverCommand();
        Scanner scanner = new Scanner(System.in);
        Command startGame = new StartGame(command);
        Command loadGame = new LoadGame(command);
        Command exitGame = new ExitGame(command);

        Menu menu = new Menu();
        menu.regCommand(1, startGame);
        menu.regCommand(2, loadGame);
        menu.regCommand(3, exitGame);

        while (true) {
            int choice;
            System.out.println("Выберите пункт: ");
            for (Map.Entry<Integer, Command> pair : menu.getCommand().entrySet()) {
                System.out.println(pair.getKey() + ". " + pair.getValue());
            }
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice <= menu.getCommand().size()) {
                    menu.execute(choice);
                    break;
                }
                System.out.println("Нет такого пункта! Попробуйте снова:");
            } else {
                System.out.println("Не корректный ввод! Попробуйте снова:");
                scanner.next();
            }
        }
    }
}

