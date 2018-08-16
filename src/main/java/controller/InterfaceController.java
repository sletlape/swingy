package controller;

/*Store all values in variables then pass the variable to GUI or CLI*/

import enums.EInterfaces;
import view.Cli;
import view.Gui;
import view.UserInterface;

public class InterfaceController {
    protected String    userName;
    protected String    avatarType;
    protected int       xp;

    public InterfaceController(String userName, String avatarType, int xp){
        this.userName = userName;
        this.avatarType = avatarType;
        this.xp = xp;
    }

    public UserInterface chosenInterface(EInterfaces userChoice, int width, int height){

        if (userChoice.name().equals("CLI")) {
            Cli cli = new Cli();
            return cli;
        }
        if (userChoice.name().equals("GUI")){
            Gui gui = new Gui("Swingy", 300,300);
            return gui;
        }
        return null;
    }
}
