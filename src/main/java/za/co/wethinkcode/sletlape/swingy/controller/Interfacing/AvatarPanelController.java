package za.co.wethinkcode.sletlape.swingy.controller.Interfacing;

import za.co.wethinkcode.sletlape.swingy.model.LivingElements.Hero;
import za.co.wethinkcode.sletlape.swingy.view.gui.AvatarPanel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class AvatarPanelController {
    private final ArrayList<Hero> heroes;
    private final boolean isFromDatabase;
    AvatarPanel avatarPanel;
    GUIController guiController;
    private int indexSelected;
    private String playerName = "";


    public AvatarPanelController(GUIController guiController, AvatarPanel AvatarPanel, ArrayList<Hero> heroes, boolean isFromDatabase) {
        this.avatarPanel = AvatarPanel;
        this.guiController = guiController;
        this.heroes = heroes;
        this.isFromDatabase = isFromDatabase;
        guiController.updateUserInterface();
        addAllListeners();
    }

    private void addAllListeners() {
        avatarPanel.addSelectListener(onSelectedListener);
        avatarPanel.addTxtPlayerNameDocumentListener(txtPlayerNameDocListener);
        avatarPanel.addBtnSubmitListener(onSumbit);
    }

    private AbstractAction onSelectedListener = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            AvatarPanel.CustomRadioButton button = (AvatarPanel.CustomRadioButton) e.getSource();
            indexSelected = button.getTag();
        }
    };

    private DocumentListener txtPlayerNameDocListener = new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            updatePlayerName(e);
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            updatePlayerName(e);
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            updatePlayerName(e);
        }
    };


    private void updatePlayerName(DocumentEvent e){
        try {
            playerName = e.getDocument().getText(0, e.getOffset());
        } catch (BadLocationException e1) {
            e1.printStackTrace();
        }
        System.out.println(playerName);
    }

    private AbstractAction onSumbit = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Hero hero = heroes.get(indexSelected);
            guiController.loadProfile(hero);
            guiController.setPlayerName(isFromDatabase ? hero.getName() : playerName);
            if (guiController.arenaController.isPlayerValid())
                guiController.showWorldPanel();
            else {
                    //Player valid error
                }
            }
    };
}
