package view;

import model.LivingElements.Hero;
import model.LivingElements.LiveEntity;
import model.LivingElements.Villain;
import model.mapElements.Arena;
import model.mapElements.WorldMap;

import java.awt.*;

public class Cli implements UserInterface{

    public void displayWelcomeMessage() {
        System.out.println("Welcome to swingy-prison break!");
        System.out.println("Press enter to continue!");
    }
    public void prompUserAction() {
        System.out.println("=================================");
        System.out.println("||To switch to GUI, press \"x\"||");
        System.out.println("||To exit the game, press \"q\"||");
        System.out.println("||To play the game, press \"p\"||");
        System.out.println("=================================");
        System.out.println("=================================");
        System.out.println("||To move up, press \"w\"||");
        System.out.println("||To move Down, press \"s\"||");
        System.out.println("||To move Left, press \"a\"||");
        System.out.println("||To move Right, press \"f\"||");
        System.out.println("=================================");
        System.out.println("What do you want to do?");
        System.out.println("=================================");
    }


    private void displayMap(WorldMap worldMap) {
        Point point = new Point();

        for (int y = 0; y < worldMap.getSize(); y++) {
            for (int x = 0; x < worldMap.getSize(); x++) {
                point.x = x;
                point.y = y;
                LiveEntity player = worldMap.getMap().get(point);
                if (player == null)
                    System.out.print("[ ]");
                else if (player instanceof Hero)
                    System.out.print("[H]");
                else if (player instanceof Villain)
                    System.out.print("[V]");

            }
            System.out.println();
        }
    }

    public void userName(){
        System.out.println("Please enter a username: ");
    }

    public void displayGoodMessage() { System.out.println("Bye"); }

    public void greating(String username) {
        System.out.println("Hello "+username+", please select your avatar:");
        System.out.println("[1] \t Lincoln");
        System.out.println("[2] \t Michael");
        System.out.println("[3] \t Fernando");
    }

    public void displayInvalidCharacterType() {
        System.out.println("Choice is not recognised, please try again.");
    }

    @Override
    public void updateInterface(Arena arena) {
        displayMap(arena.getWorldMap());
        prompUserAction();
    }
}
