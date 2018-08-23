package controller.Interfacing;

import controller.Entity.ArenaController;
import enums.EDirection;
import enums.EHeroClass;

public abstract class AbstractInterfaceController {
    ArenaController arenaController;


    public AbstractInterfaceController(ArenaController arenaController) {
        this.arenaController = arenaController;
    }

    public void createHero(EHeroClass heroClass) {
        arenaController.createHero(heroClass);
    }

    public void move(EDirection direction){
        arenaController.move(direction);
        updateUserInterface();
    }
    abstract void run();
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
}
