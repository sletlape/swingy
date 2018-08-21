package model.mapElements;

import lombok.Getter;
import lombok.Setter;
import model.LivingElements.Hero;
import model.LivingElements.Villan;

import java.util.ArrayList;

@Setter @Getter
public class Arena {
    WorldMap worldMap;
    ArrayList<Villan> villans;
    Hero hero;

    public Arena(WorldMap worldMap, ArrayList<Villan> villans) {
        this.worldMap = worldMap;
        this.villans = villans;
    }
}
