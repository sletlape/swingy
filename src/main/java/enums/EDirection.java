package enums;

public enum  EDirection {
    UP(-1),
    DOWN(1),
    LEFT(-1),
    RIGHT(1);

    @lombok.Getter
    private final int increment;

    EDirection(int i) {
        increment = i;
    }
}