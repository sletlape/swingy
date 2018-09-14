package controller.Interfacing;

import controller.Entity.ArenaController;
import enums.EHeroClass;
import factory.HeroFactory;
import model.LivingElements.Hero;
import view.gui.*;

import javax.swing.*;
import java.util.ArrayList;

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

    public void showNewAvatarPanel() {
        ArrayList<Hero> heroes = getNewProfiles();
        AvatarPanel avatarPanel = new AvatarPanel(heroes, false);
        AvatarPanelController avatarPanelController = new AvatarPanelController(this, avatarPanel, heroes, false);
        switchPanel(avatarPanel);
    }

    public void showOldAvatarPanel() {
        ArrayList<Hero> heroes = getAllProfiles();
        AvatarPanel avatarPanel = new AvatarPanel(heroes, true);
        AvatarPanelController avatarPanelController = new AvatarPanelController(this, avatarPanel, heroes, true);
        switchPanel(avatarPanel);
    }

    private ArrayList<Hero> getNewProfiles() {
        ArrayList<Hero> heroes = new ArrayList<>();
        for (EHeroClass heroClass: EHeroClass.values())
            heroes.add(HeroFactory.newHero(heroClass));
        return heroes;
    }

}