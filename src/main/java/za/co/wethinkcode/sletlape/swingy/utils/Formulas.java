package za.co.wethinkcode.sletlape.swingy.utils;

public class Formulas {
    public static int getMapSize(int level) {
        return (level-1)*5+10-(level%2);
    }

    public static int toNextLevel(int level) {
        int nextLevel = (int) (level*100+Math.pow(level-1,2)*450);
        return nextLevel;
    }
}
