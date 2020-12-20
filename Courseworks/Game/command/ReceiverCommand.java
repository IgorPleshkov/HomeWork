package Courseworks.Game.command;

import Courseworks.Game.gamePlay.InitGame;
import Courseworks.Game.gamePlay.ProcessGame;
import Courseworks.Game.gamePlay.StepGame;
import Courseworks.Game.gamePlay.StructureGame;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Scanner;

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

