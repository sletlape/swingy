package za.co.wethinkcode.sletlape.swingy.state;

import lombok.Getter;
import lombok.Setter;
import za.co.wethinkcode.sletlape.swingy.model.mapElements.Arena;

@Getter @Setter
public class Game {
    private static Game ourInstance = new Game();

    private boolean isGameOver = false;
    private Arena arena;

    public static Game getInstance() {
        return ourInstance;
    }
}
