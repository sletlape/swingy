package controller.Interfacing;

import enums.EInterfaces;

public class GameController {

    public void initGame(EInterfaces userInterface){
        AbstractInterfaceController controller =
                userInterface == EInterfaces.CLI ?
                        new CLIController() : new GUIController();
        controller.run();
    }
}
