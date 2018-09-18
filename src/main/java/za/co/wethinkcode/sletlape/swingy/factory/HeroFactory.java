package za.co.wethinkcode.sletlape.swingy.factory;

import za.co.wethinkcode.sletlape.swingy.enums.EArtifactClass;
import za.co.wethinkcode.sletlape.swingy.enums.EHeroClass;
import za.co.wethinkcode.sletlape.swingy.model.LivingElements.Hero;

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
