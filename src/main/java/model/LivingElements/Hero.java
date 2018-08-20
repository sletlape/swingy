package model.LivingElements;

import enums.EHeroClasses;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Hero extends LiveEntity{

    EHeroClasses heroClass;

    public Hero(){

        /*Prisoner names:
        * --Lincoln 'the brute'
        * --Michael 'the legend'
        * --Fernando 'the sceptic'
        * */
    }


    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public int getHp() {
        return this.hp;
    }

    @Override
    public void setXp(int xp) {
        this.xp = xp;
    }

    @Override
    public int getXp(int xp) {
        return this.xp;
    }
}
