package view.gui;

import lombok.Getter;
import lombok.Setter;
import model.LivingElements.Hero;
import model.mapElements.Arena;
import view.UserInterface;

import java.util.ArrayList;


@Getter @Setter
public class Gui implements UserInterface {

    MainWindow mainWindow = new MainWindow();
    AWindowPanel currentPanel;
    public Gui() {
        mainWindow.setVisible(true);
    }

    @Override
    public void displayHeroStats(String heroName, String heroType, int heroXp, int heroHp, int heroLevel) {

    }

    @Override
    public void promptProfileSelection() {

    }

    @Override
    public void chooseAvatarType() {

    }

    @Override
    public void userName() {

    }

    @Override
    public void updateInterface(Arena arena) {
        currentPanel.updatePanel(arena);
    }

    @Override
    public void displayGoodByeWin() {

    }

    @Override
    public void displayGoodByeLost() {

    }

    @Override
    public void displayOldProfiles(ArrayList<Hero> profiles) {

    }

    @Override
    public void displayEmptyDatabaseError() {

    }

    public void switchPanel(AWindowPanel panel) {
        currentPanel = panel;
        mainWindow.setContentPane(panel);
        mainWindow.setVisible(true);
    }
}