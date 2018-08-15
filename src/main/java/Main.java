import com.sun.tools.javac.code.Attribute;
import enums.EInterfaces;
import view.Cli;

import java.util.*;

public class Main {

    public static void main(String args[]){
        if (validArgs(args)){
            Enum userChoice = getInterface(args[0].toUpperCase());
            if (userChoice.name().equals("CLI")){
                Cli usrInter = new Cli();
            }
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
