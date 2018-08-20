package controller.Interfacing;

import controller.Entity.playerController;
import view.Cli;

import java.io.IOException;
import java.util.Scanner;

public class CLIController extends AbstractInterfaceController{
    Cli  userInterface = new Cli();

    Scanner scanner = new Scanner(System.in);

    @Override
    public void start() {
        run();
    }

    @Override
    void run() {
        userInterface.displayWelcomeMessage();
        waitForEnterPress();
        gameLoop();
    }

    private void gameLoop() {
        String input;
        do {
            userInterface.promptUserAction();
            input = scannerGetInput();
        } while (!evaluate(input));
    }

    private boolean evaluate(String input) {
        switch (input)
        {
           case  "q" :
               quitGame();
               break;
            case "p" :
                playGame();
                return true;
           case "x" :
               switchUI();
               return true;
        }
        return false;
    }

    private void playGame() {

        userInterface.userName();
        String username = scanner.nextLine();
        userInterface.greating(username);

        String avatarType = gettingAvatarChoice();
        System.out.println("Hello "+username+" "+avatarType);

        playerController player = new playerController(username, avatarType);
    }

    private String gettingAvatarChoice() {
        boolean choiceMade = false;

        String charType = "";
        while (!choiceMade) {
            charType = scanner.nextLine();
            if (charType == "1") {
                charType = "Lincoln";
                choiceMade = true;
            } else if (charType == "2") {
                charType = "Michael";
                choiceMade = true;
            } else if (charType == "3") {
                charType = "Fernando";
                choiceMade = true;
            } else
                System.out.println("Choice is not recognised, please try again.");
        }
        return charType;
    }

    @Override
    void switchUI() {
        AbstractInterfaceController controller =
                new GUIController();
        controller.run();
    }

    private void quitGame() {
        userInterface.displayGoodMessage();
        System.exit(0);
    }

    private String scannerGetInput() {
        return scanner.nextLine();
    }

    private void waitForEnterPress() {
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
