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
        selectProfile();
        //
        gameLoop();
    }

    @Override
    void selectProfile() {
        userInterface.promptProfileSelection();

        String input = scannerGetInput();

        if (input.equals("1"))
            prePlayInitialisation();
        else if (input.equals("2"))
            ///Todo: get user to select profile
            arenaController.getAllProfiles();
        else
            userInterface.displayInputError();

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
            userInterface.displayInputError();
        }

        if (input.equals("i")){
            showStats();
        }
        if (input.equals("q")){
            quitGame();
        }

        if (input.equals("x")){
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

        userInterface.chooseAvatarType();
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

    private void showStats() {
        String heroName = arenaController.getArena().getHero().getName();
        String heroType = arenaController.getArena().getHero().getHeroClass().toString();

        int heroXp = arenaController.getArena().getHero().getXp();
        int heroHp = arenaController.getArena().getHero().getHp();
        int heroLevel = arenaController.getArena().getHero().getLevel();

        Cli.displayHeroStats(heroName, heroType, heroXp, heroHp, heroLevel);
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

    public void waitForEnterPress() {
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
