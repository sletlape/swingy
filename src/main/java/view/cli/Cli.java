package view.cli;

import model.LivingElements.Hero;
import model.LivingElements.LiveEntity;
import model.LivingElements.Villain;
import model.mapElements.Arena;
import model.mapElements.WorldMap;
import model.util.GameMessages;
import view.UserInterface;

import java.awt.*;
import java.util.ArrayList;

public class Cli implements UserInterface {

    public static void displayHeroStats(String heroName, String heroType, int heroXp, int heroHp, int heroLevel) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("Hero name:\t\t"+heroName);
        System.out.println("Hero class:\t\t" +heroType);
        System.out.println("Hero XP:\t\t"+heroXp);
        System.out.println("Hero HP:\t\t"+heroHp);
        System.out.println("Hero level:\t\t"+heroLevel);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    public void promptProfileSelection() {
        System.out.println("Please select an profile type:");
        System.out.println("[1] \t New Profile");
        System.out.println("[2] \t Old Profile");
    }

    public void displayWelcomeMessage() {
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("Welcome to swingy-prison break!");
        System.out.println("Press enter to continue!");
    }



    public void greeting(String username) {
        System.out.println("Hello " + username + ", please select your avatar:");
    }

    public void chooseAvatarType(){
        System.out.println("Please select an avatar type:");
        System.out.println("[1] \t Lincoln");
        System.out.println("[2] \t Michael");
        System.out.println("[3] \t Fernando");
    }

    public void userName() {
        System.out.println("Please enter a username: ");
    }

    private void promptUserInteraction() {
        System.out.println("=================================");
        System.out.println("||To view your stats, press \"i\"||");
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

    public void displayInputError() {
        System.out.println("Invalid input, please select from the above options!");
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

    public void displayGoodByeMessage() {
        System.out.println("Bye");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
    }

    public void displayInvalidCharacterType() {
        System.out.println("Choice is not recognised, please try again.");
    }

    public static void displayTooSowForEnemyMsg() {
        System.out.println("The enemy is too fast for you, you have to fight.");
    }

    @Override
    public void updateInterface(final Arena arena) {
        if (arena.isWasInfight())
            displayArenaMessages(arena.getGameMessages());
        promptUserInteraction();
        displayMap(arena);
        promptUserAction(arena.isInFight());
    }

    private void displayArenaMessages(final GameMessages gameMessages) {
        for (String string : gameMessages.getMessages())
            System.out.println(string);
        System.out.println("***************************************");
    }

    @Override
    public void displayGoodByeWin() {
        System.out.println("*************************************************************************");
        System.out.println("You have escaped, congratulations you are free to continue with your day.");
        System.out.println("*************************************************************************");
    }

    public void displayGoodByeLost() {
        System.out.println("*************************************************************************");
        System.out.println("Your HP is 0, You have lost..");
        System.out.println("Your HP has been reset to 100 and all other values are saved!");
        System.out.println("*************************************************************************");
    }

    public void displayOldProfiles(ArrayList<Hero> profiles) {
        String format = "%-20s %-20s\n";
        System.out.println("*************************");
        System.out.println("Profiles from database");
        System.out.println("*************************");
        System.out.format( format + "\n", "Profile ID", "User Name");

        int count = 1;

        for (Hero heroProfiles : profiles) {
            System.out.format( format, count++, heroProfiles.getName());
        }
        System.out.println("Select profile ID");
    }

    public void displayEmptyDatabaseError() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("You the database is empty, please select option 1 \"New Profile\"!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}