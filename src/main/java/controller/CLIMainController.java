package controller;

import view.Cli;

public class CLIMainController extends InterfaceController{
    public CLIMainController(String name, String avatarType, int xp){
        super(name, avatarType, xp);
        System.out.println("####################################################################");
        System.out.println("+-----------------------------------+");
        System.out.println("|Running the Command Line Interface!|");
        System.out.println("+-----------------------------------+");
        System.out.println("\nUser:\t\t\t" + name);
        System.out.println("Avatar:\t\t" + avatarType);
        System.out.println("XP:\t\t\t\t " + name);
        System.out.println("\n####################################################################");

    }
}
