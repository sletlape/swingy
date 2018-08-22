package factory;

import controller.Entity.ArenaController;
import model.LivingElements.Villain;
import model.mapElements.Arena;
import model.mapElements.WorldMap;
import state.Game;

import java.util.ArrayList;

public class ArenaControllerFactory {
    public static ArenaController newArenaFromTheGameState() {
        WorldMap worldMap = new WorldMap();
        ArrayList<Villain> villains = new ArrayList<>();

        Arena arena = new Arena(worldMap, villains);
        Game.getInstance().setArena(arena);

        ArenaController arenaController = new ArenaController(arena);
        return arenaController;
    }
}
