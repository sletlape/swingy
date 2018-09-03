package factory;

import enums.EArtifactClass;
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
                Villain = newMahone();
                break;
            case Bellick:
                Villain = newBellick();
                break;
        }
        return Villain;
    }

    private static Villain newTBag() {
        int xp = 1;
        int hp = 100;
        String VillainClass = "TBag";
        return new Villain(VillainClass, hp, xp, EArtifactClass.Shank);
    }

    private static Villain newMahone() {
        int xp = 1;
        int hp = 55;
        String VillainClass = "Mahone";
        return new Villain(VillainClass, hp, xp, EArtifactClass.Gun);
    }

    private static Villain newBellick() {
        int xp = 1;
        int hp = 70;
        String VillainClass = "Bellick";
        return new Villain(VillainClass, hp, xp, EArtifactClass.Taser);
    }

    public static ArrayList<LiveEntity> randomVillain(int mapSize) {
        ArrayList<LiveEntity> villainArrayList = new ArrayList<>();

        Villain villain = null;

        for (int i = 0; i < mapSize; i++) {

            villain = makeRandomVillainType();

            villain.setPoint(putVillainRandomly(mapSize));
            villainArrayList.add(villain);
        }
        return villainArrayList;
    }

    private static Villain makeRandomVillainType() {


        int villainTypeID = randomizer(3);

        switch (villainTypeID){
            case 1:
                return newVillain(EVillainClass.Mahone);
            case 2:
                return newVillain(EVillainClass.Bellick);
            default:
                return newVillain(EVillainClass.TBag);
        }
    }

    private static Point putVillainRandomly(int mapSize) {
        Point villainPoint =  new Point();

        villainPoint.x = randomizer(mapSize);
        villainPoint.y = randomizer(mapSize);

        return villainPoint;
    }


    private static int randomizer(int size) {

        Random rnd = new Random();

        int randomOnMap = rnd.nextInt(size);

        return randomOnMap;
    }
}
