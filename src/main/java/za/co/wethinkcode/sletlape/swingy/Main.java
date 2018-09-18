package za.co.wethinkcode.sletlape.swingy;

import za.co.wethinkcode.sletlape.swingy.controller.Interfacing.GameController;
import za.co.wethinkcode.sletlape.swingy.enums.EInterface;

public class Main {

    public static void main(String args[]){
        if (validArgs(args)){
            EInterface userChoice = getInterface(args[0].toUpperCase());

            GameController gameController = new GameController();
            gameController.initGame(userChoice);
        }
    }

    private static boolean validArgs(String[] args) {
        if (args.length == 1) {
            return true;
        }
        System.out.println("You can only pass 1 argument!");
        return false;
    }

    private static EInterface getInterface(String argsUpper) {
        if (argsUpper.equals("CLI"))
            return EInterface.CLI;
        else if (argsUpper.equals("GUI"))
            return EInterface.GUI;
        else{
            System.out.println("Interfaces can only be 'CLI' or 'GUI'");
            System.exit(0);
        }
        return null;
    }
}
