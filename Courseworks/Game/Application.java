package Courseworks.Game;

import Courseworks.Game.command.*;

import java.util.Map;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReceiverCommand command = new ReceiverCommand();

        Command startGame = new StartGame(command);
        Command loadGame = new LoadGame(command);
        Command exitGame = new ExitGame(command);

        Menu menu = new Menu();
        menu.regCommand(1, startGame);
        menu.regCommand(2, loadGame);
        menu.regCommand(3, exitGame);

        System.out.println("Выберите пункт: ");
        for (Map.Entry<Integer, Command> pair : menu.getCommand().entrySet()) {
            System.out.println(pair.getKey() + ". " + pair.getValue());
        }
        int choice;

        if (scanner.hasNextInt()) {
            menu.execute(scanner.nextInt());
        } else System.out.println("Не корректный ввод!");

    }
}

