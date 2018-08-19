import controller.Interfacing.GameController;
import enums.EInterfaces;

public class Main {

    public static void main(String args[]){
        if (validArgs(args)){
            EInterfaces userChoice = getInterface(args[0].toUpperCase());
            GameController gameController = new GameController();
            gameController.initGame(userChoice);
        }
    }

    private static boolean validArgs(String[] args) {
        if (args.length != 1) {
                System.out.println("You can only pass 1 argument!");
            return false;
        }
        return true;
    }

    private static EInterfaces getInterface(String argsUpper) {
        if (argsUpper.equals("CLI"))
            return EInterfaces.CLI;
        else if (argsUpper.equals("GUI"))
            return EInterfaces.GUI;
        else
            System.out.println("Interfaces can only be 'CLI' or 'GUI'");
        return null;
    }
}
