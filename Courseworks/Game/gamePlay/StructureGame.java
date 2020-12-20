package Courseworks.Game.gamePlay;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class StructureGame implements Serializable {
   private Set<StepGame> stepsGame = new HashSet<>();

   public void addSteps(StepGame step){
       stepsGame.add(step);
   }

    public Set<StepGame> getStepsGame() {
        return stepsGame;
    }
}
