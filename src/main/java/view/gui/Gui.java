package view.gui;

import lombok.Getter;
import lombok.Setter;
import model.mapElements.Arena;
import view.UserInterface;


@Getter @Setter
public class Gui implements UserInterface {

    MainWindow mainWindow = new MainWindow();
    IWindowPanel currentPanel;
    public Gui() {
        mainWindow.setVisible(true);
    }

    @Override
    public void updateInterface(Arena arena) {
        currentPanel.updatePanel(arena);
    }

    @Override
    public void displayGoodByeWin() {

    }

    public void switchPanel(IWindowPanel panel) {
        currentPanel = panel;
        mainWindow.setContentPane(panel);
        mainWindow.setVisible(true);
    }
}