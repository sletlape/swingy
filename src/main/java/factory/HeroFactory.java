package factory;

import enums.EArtifactClass;
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
        return new Hero(heroClass, EHeroClass.Lincoln, EArtifactClass.Gun);
    }

    private static Hero newMichael() {
        String heroClass = "Michael";
        return new Hero(heroClass, EHeroClass.Michael, EArtifactClass.Taser);
    }

    private static Hero newFernando() {
        String heroClass = "Fernando";
        return new Hero(heroClass, EHeroClass.Fernando, EArtifactClass.Shank);
    }
}
