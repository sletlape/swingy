package controller.Entity;

import model.Artifacts.Artifact;
import model.LivingElements.Hero;
import utils.Formulas;

import java.awt.*;

public class PlayerController {
    Hero hero;

    void levelUp(int points) {
    }

    void collectAritfact(Artifact artifact) {
    }

    void registerHero(Hero hero){
        this.hero = hero;
        putHeroInTheCenter();
    }

    private void putHeroInTheCenter() {
        Point heroPoint = hero.getPoint();
        int mapSize = Formulas.getMapSize(hero.getLevel());
        heroPoint.x = mapSize /2;
        heroPoint.y = mapSize /2;
    }

    public void returnToLastPoint() {
        hero.setPoint(hero.getLastPoint());
    }
}
