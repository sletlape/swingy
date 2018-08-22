package model.LivingElements;

import enums.EHeroClass;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter @Setter
public class Hero extends LiveEntity{

    EHeroClass heroClass;
    Point lastPoint = null;

    public Hero(String name, EHeroClass heroClass) {
        super(name, 100, 1, 1);
        this.heroClass = heroClass;
        this.lastPoint = this.point;
    }
}
