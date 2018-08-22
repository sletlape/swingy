package factory;

import enums.EVillainClass;
import model.LivingElements.Villain;

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
        int level = 1;
        int hp = 1;
        String VillainClass = "TBag";
        return new Villain(VillainClass, hp, xp, level);
    }
}
