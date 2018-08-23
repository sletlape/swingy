package controller.Entity;

import controller.Battle;
import enums.EDirection;
import enums.EHeroClass;
import factory.HeroFactory;
import lombok.Getter;
import model.LivingElements.Hero;
import model.LivingElements.LiveEntity;
import model.mapElements.Arena;

import java.awt.*;
import java.util.Random;

@Getter
public class ArenaController {
    Arena arena;
    PlayerController playerController = new PlayerController();
    MapController mapController = new MapController();
    Battle battle = new Battle();
    public ArenaController(Arena arena) {
        this.arena = arena;
    }

    public void move(EDirection direction) {
        Point newPoint = new Point(arena.getHero().getPoint());
        arena.getHero().setLastPoint(arena.getHero().getPoint());

        if (isWithinBoundaries(direction))
        {
            //Point runToPoint = arena.getHero().getPoint();
            switch (direction) {
                case UP:
                    newPoint.y--;
                    break;
                case DOWN:
                    newPoint.y++;
                    break;
                case LEFT:
                    newPoint.x--;
                    break;
                case RIGHT:
                    newPoint.x++;
                    break;
            }
        }
        mapController.removeObject(arena.getHero().getPoint());
        arena.getHero().setPoint(newPoint);

        if (isColliding(newPoint))
            arena.setInFight(true);
        else
            mapController.addObject(arena.getHero());
    }

    private boolean isColliding(Point newPoint) {
        return mapController.containsEnemy(newPoint);
    }

    private boolean isWithinBoundaries(EDirection direction) {
        Point playerPosition = arena.getHero().getPoint();
        int mapSize = arena.getWorldMap().getSize();
        int newValue;

        if (direction == EDirection.UP || direction == EDirection.DOWN) {
            newValue = playerPosition.y + direction.getIncrement();
            return newValue >= 0 && newValue < mapSize;
        }
        else {
            newValue = playerPosition.x + direction.getIncrement();
            return newValue >= 0 && newValue < mapSize;
        }
    }

    public void createHero(EHeroClass heroClass) {
        Hero hero = HeroFactory.newHero(heroClass);

        arena.setHero(hero);

        playerController.registerHero(hero);
        mapController.initializeMap(arena.getWorldMap(), hero.getLevel());
        mapController.addObject(hero);
    }

    public void fight() {
        if (this.arena.isInFight()){
            Point heroPoint = arena.getHero().getPoint();
            LiveEntity  villain = mapController.getObject(heroPoint);
            LiveEntity winner = battle.fight(arena.getHero(), villain);

            if (winner == arena.getHero()) {
                mapController.addObject(winner);
                arena.getHero().setXp(arena.getHero().getXp()+(10*arena.getHero().getLevel()));
                arena.setInFight(false);
                playerController.levelUp();
            }
            else
                arena.setGameOver(true);
        }
    }

    public void run(){
        Random rndm = new Random();
        int success = rndm.nextInt(2);

        if (success == 1){
            System.out.println("You are running away");
            backToLastPoint();
        }else {
            System.out.println("Cannot run away, you have to fight");
            ///TODO:
            //setup fight sequence here
        }
    }

    protected void backToLastPoint(){
        playerController.returnToLastPoint();
        mapController.addObject(arena.getHero());
    }

}
