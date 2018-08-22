package factory;

import enums.EVillainClass;
import model.LivingElements.LiveEntity;
import model.LivingElements.Villain;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class VillainFactory {
    public static Villain newVillain(EVillainClass VillainClass) {
        Villain Villain = null;
        switch (VillainClass) {
            case TBag:
                Villain = newTBag();
                break;
            case Mahone:
                break;
            case Bellick:
                break;
        }
        return Villain;
    }

    private static Villain newTBag() {
        int xp = 10;
        int hp = 1;
        String VillainClass = "TBag";
        return new Villain(VillainClass, hp, xp);
    }

    public static ArrayList<LiveEntity> randomVillain(int mapSize) {
        ArrayList<LiveEntity> villainArrayList = new ArrayList<>();
        for (int i = 0; i < mapSize; i++) {
            Villain villain = newVillain(EVillainClass.TBag);
            villain.setPoint(putVillainRandomly(mapSize));
            villainArrayList.add(villain);
        }
        return villainArrayList;
    }


    private static Point putVillainRandomly(int mapSize) {
        Point villainPoint =  new Point();

        villainPoint.x = randomisePoint(mapSize);
        villainPoint.y = randomisePoint(mapSize);

        return villainPoint;
    }


    private static int randomisePoint(int mapSize) {

        Random rnd = new Random();

        int randomOnMap = rnd.nextInt(mapSize);

        return randomOnMap;
    }
}
