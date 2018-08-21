package controller.Interfacing;

import enums.EHeroClasses;
import view.gui.MenuPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController {
    private final MenuPanel menuPanel;
    private final GUIController guiController;

    public MenuController(GUIController guiController, MenuPanel menuPanel) {
        this.menuPanel = menuPanel;
        this.guiController = guiController;
        addAllListeners();
    }

    private AbstractAction newHeroListener = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            guiController.createHero(EHeroClasses.Lincoln);
            guiController.showWorldPanel();
        }
    };

    private void addAllListeners() {
        menuPanel.addBtnNewHeroListener(newHeroListener);
    }




}
