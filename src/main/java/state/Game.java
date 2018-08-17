package state;

import lombok.Getter;
import lombok.Setter;

public class Game {
    private static Game ourInstance = new Game();

    @Getter @Setter
    private boolean isGameOver = false;

        public static Game getInstance() {
        return ourInstance;
    }

    private Game() {
    }
}
