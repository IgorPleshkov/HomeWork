package Courseworks.Game.command;

import Courseworks.Game.gamePlay.ProcessGame;


public class ReceiverCommand {
    public void startGame() {
        ProcessGame.play();
    }

    public void loadGame() {
       ProcessGame.loadGame();
    }

    public void exitGame() {
        System.out.println("Exit game");
    }

}

