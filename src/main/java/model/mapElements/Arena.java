package model.mapElements;

import lombok.Getter;
import lombok.Setter;
import model.LivingElements.Hero;
import model.LivingElements.Villain;

import java.util.ArrayList;

@Setter
@Getter
public class Arena {
    WorldMap worldMap;
    ArrayList<Villain> villains;
    Hero hero;
    boolean isInFight = false;
    boolean isGameOver = false;

    public Arena(WorldMap worldMap, ArrayList<Villain> villains) {
        this.worldMap = worldMap;
        this.villains = villains;
    }
}