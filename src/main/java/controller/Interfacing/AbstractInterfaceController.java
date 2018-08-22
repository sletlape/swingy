package controller.Interfacing;

import controller.Entity.ArenaController;
import enums.EDirection;
import enums.EHeroClass;
import model.LivingElements.LiveEntity;

import java.awt.*;
import java.util.Random;

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
    protected void fightVillan(){
        arenaController.fight();
        updateUserInterface();

    }
    protected void runFromVillan(){
        Random rndm = new Random();
        int success = rndm.nextInt(2);

        if (success == 1){
            backToLastPoint();
        }else {
            ///TODO:
            //setup fight sequence here
        }
    }

    protected void backToLastPoint(){
        Point oldPoint = arenaController.getArena().getHero().getLastPoint();
    }


}
