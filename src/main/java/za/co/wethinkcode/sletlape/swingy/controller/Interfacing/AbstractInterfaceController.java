package za.co.wethinkcode.sletlape.swingy.controller.Interfacing;

import za.co.wethinkcode.sletlape.swingy.controller.Entity.ArenaController;
import za.co.wethinkcode.sletlape.swingy.enums.EDirection;
import za.co.wethinkcode.sletlape.swingy.enums.EHeroClass;
import za.co.wethinkcode.sletlape.swingy.model.LivingElements.Hero;

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
