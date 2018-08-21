package controller.Interfacing;

import controller.Entity.ArenaController;
import enums.EInterfaces;
import factory.ArenaControllerFactory;

public class GameController {

    public void initGame(EInterfaces userInterface){

        ArenaController arenaController = ArenaControllerFactory.newArenaFromTheGameState();

        AbstractInterfaceController controller = userInterface == EInterfaces.CLI ?
                new CLIController(arenaController) : new GUIController(arenaController);
        controller.run();
    }
}
