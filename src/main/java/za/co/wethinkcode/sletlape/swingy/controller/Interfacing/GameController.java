package za.co.wethinkcode.sletlape.swingy.controller.Interfacing;

import za.co.wethinkcode.sletlape.swingy.controller.Entity.ArenaController;
import za.co.wethinkcode.sletlape.swingy.enums.EInterface;
import za.co.wethinkcode.sletlape.swingy.factory.ArenaControllerFactory;

public class GameController {

    public void initGame(EInterface userInterface){
        ArenaController arenaController = ArenaControllerFactory.newArenaFromTheGameState();

        AbstractInterfaceController controller = userInterface == EInterface.CLI ?
                new CLIController(arenaController) : new GUIController(arenaController);
        controller.run();
    }
}
