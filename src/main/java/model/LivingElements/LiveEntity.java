package model.LivingElements;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter @Setter

public abstract class LiveEntity {
    protected String name;
    protected int hp;
    protected int xp;
    protected int level;
    protected Point point;

    public LiveEntity(String name, int hp, int xp, int level) {
        this.name = name;
        this.hp = hp;
        this.xp = xp;
        this.level = level;
        this.point = new Point();
    }
}
