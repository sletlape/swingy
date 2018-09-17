package controller.Interfacing;

import controller.Entity.ArenaController;
import enums.EDirection;
import enums.EHeroClass;
import model.LivingElements.Hero;
import view.cli.Cli;

import java.io.IOException;
import java.util.ArrayList;
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
        showMenu();
        gameLoop();
        System.exit(0);
    }

    @Override
    void showMenu() {
        Boolean profileSelected = false;

        while (!profileSelected){
            userInterface.promptProfileSelection();
            String input = scannerGetInput();

            if (input.equals("1")){
                prePlayInitialisation();
                profileSelected = true;
            } else if (input.equals("2")) {
                displayOldProfiles();
                profileSelected = true;
            } else
                userInterface.displayInputError();
        }}

    private void displayOldProfiles() {
        ArrayList<Hero> profiles = (ArrayList<Hero>) arenaController.getAllProfiles();
        userInterface.displayOldProfiles(profiles);
        Boolean profileSelected = false;

        if (profiles.size() <= 0) {
            userInterface.displayEmptyDatabaseError();
            showMenu();
        }else {
            while (!profileSelected){
                String input = scannerGetInput();
                try {
                    int idChosen = Integer.parseInt(input)-1;

                    if (idChosen >= 0 && idChosen < profiles.size()) {
                        Hero profile = profiles.get(idChosen);
                        loadProfile(profile);
                        profileSelected = true;
                    }
                    else
                        userInterface.displayInputError();
                }
                catch (NumberFormatException e) {
                    userInterface.displayInputError();
                }
            }
        }
    }

    private void gameLoop() {
        String input;
        updateUserInterface();
        do {
            input = scannerGetInput();
        } while (!evaluate(input) && !arenaController.getArena().isGameOver());
        if (arenaController.getArena().getHero().getHp() > 0)
            userInterface.displayGoodByeWin();
        else{
            userInterface.displayGoodByeLost();
        } }

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

        userInterface.displayHeroStats(heroName, heroType, heroXp, heroHp, heroLevel);
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
