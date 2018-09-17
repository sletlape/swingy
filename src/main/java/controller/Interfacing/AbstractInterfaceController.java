package controller.Interfacing;

import controller.Entity.ArenaController;
import enums.EDirection;
import enums.EHeroClass;
import model.LivingElements.Hero;

import java.util.ArrayList;

public abstract class AbstractInterfaceController {
    ArenaController arenaController;

    public AbstractInterfaceController(ArenaController arenaController) {
        this.arenaController = arenaController;
    }

    public void createHero(EHeroClass heroClass) {
        arenaController.createHero(heroClass);
    }

    public void setPlayerName(String name){
        arenaController.setPlayerName(name);
    }

    public void move(EDirection direction){
        arenaController.move(direction);

        updateUserInterface();
    }

    abstract void run();

    abstract void showMenu();

    abstract void switchUI();

    abstract void updateUserInterface();

    protected void fightVillain(){
        arenaController.fight();
        updateUserInterface();
    }

    protected void runFromVillain(){
        arenaController.run();
        updateUserInterface();
    }

    protected ArrayList<Hero> getAllProfiles(){
        return (ArrayList<Hero>) arenaController.getAllProfiles();
    }


    public void loadProfile(Hero profile) {
        arenaController.loadProfile(profile);
        updateUserInterface();
    }
}
