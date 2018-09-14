package controller.Interfacing;

import enums.EDirection;
import enums.EHeroClass;
import view.gui.AvatarPanel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import java.awt.event.ActionEvent;

public class AvatarPanelController {
    AvatarPanel avatarPanel;
    GUIController guiController;
    private String playerSelected = "";
    private String playerName = "";



    public AvatarPanelController(GUIController guiController, AvatarPanel AvatarPanel) {
        this.avatarPanel = AvatarPanel;
        this.guiController = guiController;

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
            JRadioButton button = (JRadioButton) e.getSource();
            playerSelected = button.getText();
            System.out.println(playerSelected);
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
            EHeroClass heroClass = getHeroClass();
            if (heroClass != null) {
                guiController.createHero(heroClass);
                guiController.setPlayerName(playerName);
                if (guiController.arenaController.isPlayerValid())
                    guiController.showWorldPanel();
                else
                {
                    //Player valid error
                }
            }
            else {
                //Invalid hero error
            }
        }
    };

    private EHeroClass getHeroClass() {
        switch (playerSelected) {
            case "Lincoln":
                return EHeroClass.Lincoln;
            case "Michael":
                return EHeroClass.Michael;
            case "Fernando":
                return EHeroClass.Fernando;
            default:
                return null;
        }
    }


}
