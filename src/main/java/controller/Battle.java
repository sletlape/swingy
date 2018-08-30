package controller;

import model.LivingElements.Hero;
import model.LivingElements.LiveEntity;

public class Battle {

    public LiveEntity fight(Hero hero, LiveEntity villain) {

        if (hero.getXp() > villain.getHp()){
            return hero;
        }
        else
            return villain;
    }
}