package controller;

import enums.EInterfaces;
import state.Game;
import view.UserInterface;

public class GameController {

    public void initGame(EInterfaces userInterface){
        AbstractInterfaceController controller =
                userInterface == EInterfaces.CLI ?
                        new CLIMainController() : new GUIController();
        controller.run();
    }
}
