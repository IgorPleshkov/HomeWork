package Courseworks.Game.command;

public class LoadGame implements Command {
    private final ReceiverCommand command;

    public LoadGame(ReceiverCommand command) {
        this.command = command;
    }

    @Override
    public void execute() {
        command.loadGame();
    }

    @Override
    public String toString() {
        return "Load game";
    }
}
