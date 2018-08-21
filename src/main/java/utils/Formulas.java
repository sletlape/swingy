package utils;

public class Formulas {
    public static int getMapSize(int level) {
        return (level-1)*5+10-(level%2);
    }
}
