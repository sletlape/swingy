package controller.Interfacing;

import enums.EDirection;
import model.LivingElements.Hero;
import view.gui.AvatarPanel;

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
       // avatarPanel.addOnDownListener(onDownListener);

    }

    AbstractAction onDownListener = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            guiController.move(EDirection.DOWN);
            System.out.println("D\n");

        }
    };

    AbstractAction onUpListener = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            guiController.move(EDirection.UP);
            System.out.println("Up\n");
        }
    };

    AbstractAction onLeftListener = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            guiController.move(EDirection.LEFT);
        }
    };

    AbstractAction onRightListener = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            guiController.move(EDirection.RIGHT);
        }
    };

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
