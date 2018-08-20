package view;

public class Cli{

    public void displayWelcomeMessage() {
        System.out.println("Welcome to swingy-prison break!");
        System.out.println("Press enter to continue!");
    }

    public void promptUserAction() {
        System.out.println("To switch to GUI, press \"x\"");
        System.out.println("To exit the game, press \"q\"");
        System.out.println("To play the game, press \"p\"");
        System.out.println("What do you want to do?");
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
}
