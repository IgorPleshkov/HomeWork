package Courseworks.Game.command;

import Courseworks.Game.command.Command;
import Courseworks.Game.command.ReceiverCommand;

public class StartGame implements Command {
private final ReceiverCommand command;

    public StartGame(ReceiverCommand command) {
        this.command = command;
    }

    @Override
    public void execute() {
       command.startGame();
    }

    @Override
    public String toString() {
        return "Start game";
    }
}
