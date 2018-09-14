package controller.Interfacing;

import controller.Entity.ArenaController;
import view.gui.*;

import javax.swing.*;

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

    @Override
    void showMenu() {
        MenuPanel menuPanel = new MenuPanel();
        MenuController menuController = new MenuController(this, menuPanel);
        switchPanel(menuPanel);
    }


    private void switchPanel(AWindowPanel windowPanel) {
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


    public void showAvatarPanel() {
        AvatarPanel avatarPanel = new AvatarPanel();
        AvatarPanelController avatarPanelController = new AvatarPanelController(this, avatarPanel);
        switchPanel(avatarPanel);
    }
}