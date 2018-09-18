package za.co.wethinkcode.sletlape.swingy.factory;

import za.co.wethinkcode.sletlape.swingy.controller.Entity.ArenaController;
import za.co.wethinkcode.sletlape.swingy.model.LivingElements.Villain;
import za.co.wethinkcode.sletlape.swingy.model.mapElements.Arena;
import za.co.wethinkcode.sletlape.swingy.model.mapElements.WorldMap;
import za.co.wethinkcode.sletlape.swingy.state.Game;

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
