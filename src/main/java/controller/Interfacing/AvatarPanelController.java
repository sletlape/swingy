package controller.Interfacing;

import enums.EDirection;
import view.gui.AvatarPanel;
import view.gui.WorldPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AvatarPanelController {
    AvatarPanel avatarPanel;
    GUIController guiController;

    public AvatarPanelController(GUIController guiController, AvatarPanel AvatarPanel) {
        this.avatarPanel = AvatarPanel;
        this.guiController = guiController;

        guiController.updateUserInterface();
        addAllListeners();
    }

    private void addAllListeners() {
       // avatarPanel.addLister(onUpListener);
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

}
