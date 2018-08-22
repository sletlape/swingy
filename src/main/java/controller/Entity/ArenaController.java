package controller.Entity;

import enums.EDirection;
import enums.EHeroClass;
import factory.HeroFactory;
import lombok.Getter;
import model.LivingElements.Hero;
import model.mapElements.Arena;

import java.awt.*;

@Getter
public class ArenaController {
    Arena arena;
    PlayerController playerController = new PlayerController();
    MapController mapController = new MapController();

    public ArenaController(Arena arena) {
        this.arena = arena;
    }

    public void move(EDirection direction) {
        Point newPoint = new Point(arena.getHero().getPoint());


        if (isWithinBoundaries(direction))
        {
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
        mapController.addObject(arena.getHero());
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


}
