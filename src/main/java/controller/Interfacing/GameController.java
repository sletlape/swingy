package controller.Interfacing;

import controller.Entity.ArenaController;
import enums.EInterface;
import factory.ArenaControllerFactory;

public class GameController {

    public void initGame(EInterface userInterface){
///
        ArenaController arenaController = ArenaControllerFactory.newArenaFromTheGameState();

        AbstractInterfaceController controller = userInterface == EInterface.CLI ?
                new CLIController(arenaController) : new GUIController(arenaController);
        controller.run();
    }
}
