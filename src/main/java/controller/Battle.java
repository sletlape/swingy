package controller;

import controller.Interfacing.CLIController;
import model.LivingElements.Hero;
import model.LivingElements.LiveEntity;
import view.cli.Cli;

public class Battle {

    public LiveEntity fight(Hero hero, LiveEntity villain) {

        int attacker = 1;

        while ((hero.getHp() > 0) && (villain.getHp() > 0)){
            if (attacker == 1){
                villain.setHp(villain.getHp() - hero.getArtifactClass().getAttack());
                Cli.inFightMessage(hero.getName(), hero.getArtifactClass().getAttack(), villain.getName(), villain.getHp());
                attacker = 2;
            }else{
                hero.setHp(hero.getHp() - villain.getArtifactClass().getAttack());
                Cli.inFightMessage(villain.getName(), villain.getArtifactClass().getAttack(), hero.getName(), hero.getHp());
                attacker = 1;
            }
        }

        //check who dies
        if (hero.getHp() > 0){
            hero.setXp(hero.getXp()+250);
            Cli.battleWonMessage(villain.getName());
            return hero;
        }
        else
            Cli.battleLostMessage(villain.getName());
            return villain;
    }
}
