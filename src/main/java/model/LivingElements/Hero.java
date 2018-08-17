package model.LivingElements;

public class Hero extends LiveEntity{

    public Hero(String name, int hp, String attack, int xp){
        this.name = name;
        this.attack = attack;
        this.hp = hp;
        this.xp = xp;

        /*Prisoner names:
        * --Lincoln 'the brute'
        * --Michael 'the legend'
        * --Fernando 'the sceptic'
        * */
    }
}
