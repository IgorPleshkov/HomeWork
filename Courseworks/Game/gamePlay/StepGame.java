package Courseworks.Game.gamePlay;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class StepGame implements Serializable {
    private String stepName;
    private String text;
    private Map<Integer, StepGame> nextLevels;
    private boolean startStep;
    private boolean endGame;

    public StepGame(String stepName, String text, boolean endGame, boolean startStep) {
        if (stepName.trim().length() <= 3) throw new IllegalArgumentException("Название уровня д.б. больше 3 символов");
        if (text.trim().length() <= 30) throw new IllegalArgumentException("Текст д.б. больше 30 символов");
        this.stepName = stepName;
        this.text = text;
        this.startStep = startStep;
        this.endGame = endGame;
        nextLevels = new HashMap<>();
    }

    public void setStartStep(boolean startStep) {
        this.startStep = startStep;
    }

    public void setNextStep(Integer count, StepGame nextStep) {
        nextLevels.put(count, nextStep);
    }


    public boolean isEndGame() {
        return endGame;
    }

    public String getStepName() {
        return stepName;
    }

    public String getText() {
        return text;
    }

    public Map<Integer, StepGame> getNextLevels() {
        return nextLevels;
    }

    public boolean startStep() {
        return startStep;
    }

    public boolean gameOver(StepGame stepGame) {
        if (stepGame.isEndGame()) {
            return true;
        }
        return false;
    }
}
