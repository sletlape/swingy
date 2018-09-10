package controller.Entity;

import model.Artifacts.Artifact;
import model.LivingElements.Hero;
import utils.Formulas;

import java.awt.*;

public class PlayerController {
    Hero hero;

    void levelUp() {
        //level*1000+(level−1)2*450
        int level = hero.getLevel();
        int heroXp = this.hero.getXp();

        if (heroXp <= Formulas.toNextLevel(level))
            hero.setLevel(level+1);
    }

    void collectAritfact(Artifact artifact) {
    }

    void registerHero(Hero hero){
        this.hero = hero;
        putHeroInTheCenter();
    }

    private void putHeroInTheCenter() {
        Point heroPoint = new Point(0,0);
        //Point heroPoint = hero.getPoint();
        int mapSize = Formulas.getMapSize(hero.getLevel());
        heroPoint.x = mapSize /2;
        heroPoint.y = mapSize /2;
    }

    public void returnToLastPoint() {
        hero.setPoint(hero.getLastPoint());
    }

    public void setName(String name) {
        hero.setName(name);

    }
}
