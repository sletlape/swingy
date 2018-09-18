package za.co.wethinkcode.sletlape.swingy.controller;

import za.co.wethinkcode.sletlape.swingy.model.LivingElements.Hero;
import za.co.wethinkcode.sletlape.swingy.model.LivingElements.LiveEntity;
import za.co.wethinkcode.sletlape.swingy.model.util.GameMessages;

public class Battle {


    private final GameMessages gameMessages;

    public Battle(GameMessages gameMessages) {
        this.gameMessages = gameMessages;
    }

    public LiveEntity fight(Hero hero, LiveEntity villain) {

        int attacker = 1;

        while ((hero.getHp() > 0) && (villain.getHp() > 0)){
            if (attacker == 1){
                villain.setHp(villain.getHp() - hero.getArtifactClass().getAttack());

                inFightMessage(hero.getName(), hero.getArtifactClass().getAttack(), villain.getName(), villain.getHp());
                attacker = 2;
            }else{
                hero.setHp(hero.getHp() - villain.getArtifactClass().getAttack());
                inFightMessage(villain.getName(), villain.getArtifactClass().getAttack(), hero.getName(), hero.getHp());
                attacker = 1;
            }
        }

        //check who dies
        if (hero.getHp() > 0){
            hero.setXp(hero.getXp()+250);
            battleWonMessage(villain.getName());
            return hero;
        }else{
            //hero.setHp(100);
            battleLostMessage(villain.getName());
            return villain;
        }
    }

    private void inFightMessage(String attacker, int attackingPower, String defender, int attackedHealth) {
        if (attackedHealth < 0)
            attackedHealth = 0;
        gameMessages.addMessage(attacker+" inflicts "+attackingPower+" damage on "+defender);
        gameMessages.addMessage(defender+" now has "+attackedHealth+" HP");
    }

    private void battleWonMessage(String villainName) {
        gameMessages.addMessage("Congratulations, you have defeated a "+ villainName+
                ".\n You have gained 250 points");
    }

    private void battleLostMessage(String villainName) {
        gameMessages.addMessage("You have lost to "+villainName);
    }
}
