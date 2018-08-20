package controller.Entity;

import enums.EHeroClasses;
import lombok.Getter;
import lombok.Setter;
import model.LivingElements.Hero;

@Getter @Setter
public class playerController {

    public playerController(String heroName, String heroType){

        EHeroClasses character = charType(heroType);
        Hero hero = new Hero();

        hero.setName(heroName);
        hero.setHp(100);
        hero.setXp(15);
    }

    private EHeroClasses charType(String heroType) {

        switch (heroType) {
            case "Lincoln":
                return EHeroClasses.Lincoln;
            case "Michael":
                return EHeroClasses.Michael;
            case "Fernando":
                return EHeroClasses.Fernando;
        }
        return null;
    }
}
