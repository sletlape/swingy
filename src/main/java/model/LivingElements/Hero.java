package model.LivingElements;

import enums.EHeroClasses;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Hero extends LiveEntity{

    EHeroClasses heroClass;


    public Hero(String name, int hp, int xp, int level) {
        super(name, hp, xp, level);
    }
}
