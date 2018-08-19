package model.LivingElements;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter

public abstract class LiveEntity {
    protected String name;
 //   protected String attack;
    protected int hp;
    protected int xp;

    public abstract void    setName(String name);

    public abstract String  getName();

    public abstract void    setHp(int hp);

    public abstract int     getHp();

    public abstract void     setXp(int xp);

    public abstract int     getXp(int xp);
}
