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
                break;
            case Fernando:
                break;
        }
        return hero;
    }

    private static Hero newLincoln() {
        int xp = 10;
        int level = 1;
        int hp = 1;
        String heroClass = "Lincoln";
        return new Hero(heroClass, hp, xp, level);
    }
}
