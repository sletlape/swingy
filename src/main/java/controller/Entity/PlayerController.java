package controller.Entity;

import controller.ValidationControl.PlayerValidation;
import model.Artifacts.Artifact;
import model.LivingElements.Hero;
import model.LivingElements.LiveEntity;
import utils.Formulas;

import javax.validation.ConstraintViolation;
import java.awt.*;
import java.util.Set;

public class PlayerController {
    Hero hero;

    void levelUp() {
        //level*1000+(level−1)2*450
        int level = hero.getLevel();
        int heroXp = this.hero.getXp();

        ///TODO: move this line to formulas
        if (heroXp <= (level*100+Math.pow(level-1,2)*450)){
            hero.setLevel(level+1);
        }
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

    public void setName(String name) {
        hero.setName(name);

    }
}
