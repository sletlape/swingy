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
        userInterface.displayGoodByeWin();
    }

    private boolean evaluate(String input) {

        input = input.toLowerCase();

        Boolean validChoice = false;

        if (!arenaController.getArena().isInFight()){
            validChoice = moveEvaluation(input);
        }else {
            validChoice = fightOrFlight(input);
        }

        if (!validChoice){
            view.cli.Cli.displayInputError();
        }

        if (input == "q"){

            quitGame();
        }

        if (input == "x"){
            switchUI();
            return true;
        }
        return false;
    }

    private boolean fightOrFlight(String input) {
        boolean validInput = false;
        switch (input)
        {
            case "1" :
                fightVillain();
                validInput = true;
                break;
            case "2" :
                runFromVillain();
                validInput = true;
                break;
        }
        return validInput;
    }

    private boolean moveEvaluation(String input) {
        boolean validInput = false;
        switch (input){
            case  "s" :
                move(EDirection.DOWN);
                validInput = true;
                break;
            case  "d" :
                move(EDirection.RIGHT);
                validInput = true;
                break;
            case  "a" :
                move(EDirection.LEFT);
                validInput = true;
                break;
            case  "w" :
                move(EDirection.UP);
                validInput = true;
                break;
        }
        return validInput;
    }

    private void prePlayInitialisation() {

        userInterface.chooseAvaterType();
        EHeroClass avatarType = gettingAvatarChoice();
        createHero(avatarType);

        String username;
        while (!arenaController.isPlayerValid()) {
            userInterface.userName();
            username = scanner.nextLine();
            setPlayerName(username);
        }

      //  System.out.println("Hello "+username+" "+avatarType);
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
        userInterface.displayGoodByeMessage();
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
