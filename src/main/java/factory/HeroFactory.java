package factory;

import enums.EHeroClass;
import model.LivingElements.Hero;

public class HeroFactory {
    public static Hero newHero(EHeroClass heroClass) {
        Hero hero = null;
        switch (heroClass) {
            case Lincoln:
                hero = newLincoln();
                break;
            case Michael:
                hero = newMichael();
                break;
            case Fernando:
                hero = newFernando();
                break;
        }
        return hero;
    }

    private static Hero newLincoln() {
        String heroClass = "Lincoln";
        return new Hero(heroClass, EHeroClass.Lincoln);
    }

    private static Hero newMichael() {
        String heroClass = "Michael";
        return new Hero(heroClass, EHeroClass.Michael);
    }

    private static Hero newFernando() {
        String heroClass = "Fernando";
        return new Hero(heroClass, EHeroClass.Fernando);
    }
}
