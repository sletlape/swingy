package controller.Entity;

import lombok.Getter;
import lombok.Setter;
import model.LivingElements.Hero;

@Getter @Setter
public class playerConfigController {

    public playerConfigController(String heroName, String heroType){

        String character = charType(heroType);
        Hero hero = new Hero();

        hero.setName(heroName);
        hero.setHp(100);
        hero.setXp(15);
    }

    private String charType(String heroType) {

        switch (heroType){
            case "Lincoln":
                return "Lincoln";
            case "Michael":
                return "Michael";
            case "Fernando":
                return "Fernando";
        }
        return null;
    }
}
