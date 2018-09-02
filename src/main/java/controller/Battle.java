package controller;

import model.LivingElements.Hero;
import model.LivingElements.LiveEntity;
import view.cli.Cli;

public class Battle {

    public LiveEntity fight(Hero hero, LiveEntity villain) {

//        return hero;
        int attacker = 1;

        while ((hero.getHp() > 0) && (villain.getHp() > 0)){
            if (attacker == 1){
                villain.setHp(villain.getHp() - hero.getAttackPoints());
                Cli.inFightMessage(hero.getName(), hero.getAttackPoints(), villain.getName(), villain.getHp());
                attacker = 2;
            }else{
                hero.setHp(hero.getHp() - villain.getAttackPoints());
                Cli.inFightMessage(villain.getName(), villain.getAttackPoints(), hero.getName(), hero.getHp());
                attacker = 1;
            }
        }

        //check who dies
        if (hero.getHp() > 0){
            hero.setXp(hero.getXp()+25);
            Cli.battleWonMessage(villain.getName());
            return hero;
        }
        else
            Cli.battleLostMessage(villain.getName());
            return villain;
    }
}
