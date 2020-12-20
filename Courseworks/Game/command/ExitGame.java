package Courseworks.Game.command;

public class ExitGame implements Command {
    private final ReceiverCommand command;

    public ExitGame(ReceiverCommand command) {
        this.command = command;
    }

    @Override
    public void execute() {
        command.exitGame();
    }

    @Override
    public String toString() {
        return "Exit game";
    }
}
