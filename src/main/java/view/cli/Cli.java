package view.cli;

import model.LivingElements.Hero;
import model.LivingElements.LiveEntity;
import model.LivingElements.Villain;
import model.mapElements.Arena;
import model.mapElements.WorldMap;
import view.UserInterface;

import java.awt.*;

public class Cli implements UserInterface {

    public void displayWelcomeMessage() {
        System.out.println("Welcome to swingy-prison break!");
        System.out.println("Press enter to continue!");
    }

    private void promptUserInteraction() {
        System.out.println("=================================");
        System.out.println("||To switch to GUI, press \"x\"||");
        System.out.println("||To exit the game, press \"q\"||");
        System.out.println("=================================");
    }

    public void promptUserAction(boolean fightPrompt) {

        System.out.println("=================================");
        if (!fightPrompt) {
            System.out.println("||To move up, press \"w\"||");
            System.out.println("||To move Down, press \"s\"||");
            System.out.println("||To move Left, press \"a\"||");
            System.out.println("||To move Right, press \"f\"||");
            System.out.println("=================================");
        } else {
            System.out.println("[1] \t Fight");
            System.out.println("[2] \t Run");
            System.out.println("=================================");
        }
        System.out.println("What do you want to do?");
        System.out.println("=================================");
    }

    public static void displayInputError() {
        System.out.println("Invalid input, please select from the above options!");
    }

    public void greeting(String username) {
        System.out.println("Hello " + username + ", please select your avatar:");
    }

    public void chooseAvaterType(){
        System.out.println("Please select an avatar type:");
        System.out.println("[1] \t Lincoln");
        System.out.println("[2] \t Michael");
        System.out.println("[3] \t Fernando");
    }

    private void displayMap(Arena arena) {
        Point point = new Point();
        WorldMap worldMap = arena.getWorldMap();

        for (int y = 0; y < worldMap.getSize(); y++) {
            for (int x = 0; x < worldMap.getSize(); x++) {
                point.x = x;
                point.y = y;
                LiveEntity player = worldMap.getMap().get(point);

                if (player == null)
                    System.out.print("[ ]");
                else if (player instanceof Villain && player.getPoint().equals(arena.getHero().getPoint()))
                    System.out.print("[*]");
                else if (player instanceof Hero)
                    System.out.print("[H]");
                else if (player instanceof Villain)
                    System.out.print("[V]");

            }
            System.out.println();
        }
    }

    public void userName() {
        System.out.println("Please enter a username: ");
    }

    public void displayGoodByeMessage() {
        System.out.println("Bye");
    }

    public void displayInvalidCharacterType() {
        System.out.println("Choice is not recognised, please try again.");
    }

    public static void displayTooSowForEnemyMsg() {
        System.out.println("The enemy is too fast for you, you have to fight.");
    }

    @Override
    public void updateInterface(Arena arena) {
        promptUserInteraction();
        displayMap(arena);
        promptUserAction(arena.isInFight());
    }
}
