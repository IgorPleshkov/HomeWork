package Courseworks.Game.command;


import java.util.Map;
import java.util.TreeMap;

public class Menu {
    Map<Integer, Command> commandMap = new TreeMap<>();

    public void regCommand(Integer commandNumber, Command command) {
        commandMap.put(commandNumber, command);
    }

    public void execute(Integer commandNumber) {
        Command command = commandMap.get(commandNumber);
        if (command == null) {
            System.out.println("Нет такой команды!");
            return;
        }
        command.execute();
    }

    public Map<Integer, Command> getCommand() {
        return commandMap;
    }
}
