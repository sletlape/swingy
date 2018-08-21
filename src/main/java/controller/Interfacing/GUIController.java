package controller.Interfacing;

import controller.Entity.ArenaController;
import model.mapElements.WorldMap;
import view.gui.Gui;
import view.gui.IWindowPanel;
import view.gui.MenuPanel;
import view.gui.WorldPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public  class GUIController extends AbstractInterfaceController {

    Gui userInterface;

    public GUIController(ArenaController arenaController) {
        super(arenaController);
    }

    @Override
    void run() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                userInterface = new Gui();
                showMenu();
            }
        });
    }

    private void showMenu() {
        MenuPanel menuPanel = new MenuPanel();
        MenuController menuController = new MenuController(this, menuPanel);
        switchPanel(menuPanel);
    }

    private void switchPanel(IWindowPanel windowPanel) {
        userInterface.switchPanel(windowPanel);
    }

    @Override
    void switchUI() {

    }

    @Override
    void updateUserInterface() {
        userInterface.updateInterface(arenaController.getArena());
    }


    public void showWorldPanel() {
        WorldPanel worldPanel = new WorldPanel(arenaController.getArena());
        WorldPanelController menuController = new WorldPanelController(this, worldPanel);
        switchPanel(worldPanel);
    }
}
