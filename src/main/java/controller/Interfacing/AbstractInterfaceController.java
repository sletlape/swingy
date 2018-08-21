package controller.Interfacing;

import controller.Entity.ArenaController;
import enums.EDirection;
import enums.EHeroClasses;
import model.mapElements.Arena;
import view.UserInterface;

public abstract class AbstractInterfaceController {
    ArenaController arenaController;


    public AbstractInterfaceController(ArenaController arenaController) {
        this.arenaController = arenaController;

    }

    public void createHero(EHeroClasses heroClass) {
        arenaController.createHero(heroClass);
    }

    public void move(EDirection direction){
        arenaController.move(direction);
        updateUserInterface();
    }
    abstract void run();
    abstract void switchUI();
    abstract void updateUserInterface();


}
