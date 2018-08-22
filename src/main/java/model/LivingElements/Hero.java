package model.LivingElements;

import enums.EHeroClass;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Hero extends LiveEntity{

    EHeroClass heroClass;


    public Hero(String name, int hp, int xp, int level) {
        super(name, hp, xp, level);
    }
}
