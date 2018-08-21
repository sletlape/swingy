package factory;

import controller.Entity.ArenaController;
import model.LivingElements.Villan;
import model.mapElements.Arena;
import model.mapElements.WorldMap;
import state.Game;

import java.util.ArrayList;

public class ArenaControllerFactory {
    public static ArenaController newArenaFromTheGameState() {
        WorldMap worldMap = new WorldMap();
        ArrayList<Villan> villans = new ArrayList<>();

        Arena arena = new Arena(worldMap, villans);
        Game.getInstance().setArena(arena);

        ArenaController arenaController = new ArenaController(arena);
        return arenaController;
    }
}
