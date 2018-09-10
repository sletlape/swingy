package controller.Entity;

import controller.Battle;
import controller.ValidationControl.PlayerValidation;
import enums.EDirection;
import enums.EHeroClass;
import factory.HeroFactory;
import lombok.Getter;
import model.LivingElements.Hero;
import model.LivingElements.LiveEntity;
import model.mapElements.Arena;
import persistence.IRepository;
import persistence.RepositoryImpl;
import utils.Formulas;
import view.cli.Cli;

import javax.validation.ConstraintViolation;
import java.awt.*;
import java.util.Collection;
import java.util.Random;
import java.util.Set;

@Getter
public class ArenaController {
    Arena arena;
    PlayerController playerController = new PlayerController();
    MapController mapController = new MapController();
    Battle battle;
    IRepository repository;

    public ArenaController(Arena arena) {
        this.arena = arena;
        repository = new RepositoryImpl<Hero>();
        battle = new Battle(arena.getGameMessages());
    }

    public void move(EDirection direction) {
        arena.setWasInfight(false);
        arena.getGameMessages().clearMessages();
        Point newPoint = new Point(arena.getHero().getPoint());
        arena.getHero().setLastPoint(arena.getHero().getPoint());

        if (isWithinBoundaries(direction)) {
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
        }else {
            repository.update(arena.getHero());
            arena.setGameOver(true);
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
        int newPosition;

        if (direction == EDirection.UP || direction == EDirection.DOWN) {
            newPosition = playerPosition.y + direction.getIncrement();
            return newPosition >= 0 && newPosition < mapSize;
        }
        else {
            newPosition = playerPosition.x + direction.getIncrement();
            return newPosition >= 0 && newPosition < mapSize;
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
        arena.getGameMessages().clearMessages();
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
            arena.setWasInfight(true);
            repository.update(arena.getHero());
        }
    }

    public void run(){
        arena.getGameMessages().clearMessages();
        Random rndm = new Random();
        int success = rndm.nextInt(2);

        if (success == 1){
            System.out.println("You are running away");
            arena.setInFight(false);
            backToLastPoint();
        }else {
            Cli.displayTooSowForEnemyMsg();
            System.out.println("Cannot run away, you have to fight");
            fight();
        }
    }

    protected void backToLastPoint(){
        playerController.returnToLastPoint();
        mapController.addObject(arena.getHero());
    }

    public boolean isPlayerValid() {
        return arena.isValidPlayerName();
    }

    public void setPlayerName(String name) {
        playerController.setName(name);
        Set<ConstraintViolation<LiveEntity>> violations = PlayerValidation.validEntity(arena.getHero());

        if (violations.isEmpty()) {
            arena.setValidPlayerName(true);
            repository.create(arena.getHero());
        }
        else {
            for (ConstraintViolation<LiveEntity> violation: violations) {
                System.out.println(violation.getMessage());
            }
        }

    }

    public Collection getAllProfiles() {
        return repository.getAll();
    }

    public void loadProfile(Hero profile) {
        this.arena.setHero(profile);
        //set the size of the arena
        int mapSize = Formulas.getMapSize(profile.getLevel());
        this.arena.getWorldMap().setSize(mapSize);

        playerController.registerHero(profile);
        mapController.initializeMap(arena.getWorldMap(), profile.getLevel());
        mapController.addObject(profile);
    }
}
