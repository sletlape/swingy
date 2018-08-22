package controller;

import model.LivingElements.Hero;
import model.LivingElements.LiveEntity;

public class Battle {

    public LiveEntity fight(Hero hero, LiveEntity villain) {
        LiveEntity winner;

        if (hero.getXp() > villain.getXp()){
            winner = hero;
        }
        else
            winner = villain;
        return winner;
    }
}
