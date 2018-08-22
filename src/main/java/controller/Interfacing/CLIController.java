package controller.Interfacing;

import controller.Entity.ArenaController;
import enums.EDirection;
import enums.EHeroClass;
import view.cli.Cli;

import java.io.IOException;
import java.util.Scanner;

public class CLIController extends AbstractInterfaceController{

    Cli userInterface = new Cli();

    Scanner scanner = new Scanner(System.in);

    public CLIController(ArenaController arenaController) {
        super(arenaController);
    }




    @Override
    void run() {
        userInterface.displayWelcomeMessage();
        waitForEnterPress();
        prePlayInitialisation();
        gameLoop();
    }

    private void gameLoop() {
        String input;
        updateUserInterface();
        do {
            input = scannerGetInput();
        } while (!evaluate(input) && !arenaController.getArena().isGameOver());
    }

    private boolean evaluate(String input) {
        input = input.toLowerCase();
        switch (input)
        {
            case  "s" :
                move(EDirection.DOWN);
                break;
            case  "d" :
                move(EDirection.RIGHT);
                break;
            case  "a" :
                move(EDirection.LEFT);
                break;
            case  "w" :
                move(EDirection.UP);
                break;
           case  "q" :
               quitGame();
               break;
            case "1" :
                fightVillan();
                break;
            case "2" :
                runFromVillan();
                break;
           case "x" :
               switchUI();
               return true;
        }
        return false;
    }

    private void prePlayInitialisation() {
        userInterface.userName();
        String username = scanner.nextLine();
        userInterface.greating(username);

        EHeroClass avatarType = gettingAvatarChoice();
        System.out.println("Hello "+username+" "+avatarType);
        createHero(avatarType);
    }

    private EHeroClass gettingAvatarChoice() {
        boolean choiceMade = false;

        String charType;
        while (!choiceMade) {
            charType = scannerGetInput();
            switch (charType){
                case "1":
                    return EHeroClass.Lincoln;
                case "2":
                    return EHeroClass.Michael;
                case "3":
                    return EHeroClass.Fernando;
                default:
                        userInterface.displayInvalidCharacterType();
            }
        }
        return null;
    }

    @Override
    void switchUI() {
        AbstractInterfaceController controller =
                new GUIController(arenaController);
        controller.run();
    }

    @Override
    void updateUserInterface() {
        userInterface.updateInterface(arenaController.getArena());
    }

    private void quitGame() {
        userInterface.displayGoodMessage();
        System.exit(0);
    }

    private String scannerGetInput() {
        if (scanner.hasNextLine())
            return scanner.nextLine();
        else
            return "";
    }

    private void waitForEnterPress() {
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
