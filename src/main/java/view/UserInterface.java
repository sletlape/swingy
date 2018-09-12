package view;

import model.LivingElements.Hero;
import model.mapElements.Arena;

import java.util.ArrayList;

public interface UserInterface {

    void displayHeroStats(String heroName, String heroType, int heroXp, int heroHp, int heroLevel);

    void promptProfileSelection();

    void chooseAvatarType();

    void userName();

    void updateInterface(Arena arena);

    void displayGoodByeWin();

    void displayGoodByeLost();

    void displayOldProfiles(ArrayList<Hero> profiles);

    void displayEmptyDatabaseError();
}
