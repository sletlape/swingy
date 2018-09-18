package za.co.wethinkcode.sletlape.swingy.controller.Interfacing;

import za.co.wethinkcode.sletlape.swingy.enums.EDirection;
import za.co.wethinkcode.sletlape.swingy.view.gui.WorldPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class WorldPanelController {
    WorldPanel worldPanel;
    GUIController guiController;

    public WorldPanelController(GUIController guiController, WorldPanel worldPanel) {
        this.worldPanel = worldPanel;
        this.guiController = guiController;
        guiController.updateUserInterface();
        addAllMoveListeners();
    }

    private void addAllMoveListeners() {
        worldPanel.addOnUpListener(onUpListener);
        worldPanel.addOnDownListener(onDownListener);
        worldPanel.addOnLeftListener(onLeftListener);
        worldPanel.addOnRightListener(onRightListener);
    }

    AbstractAction onDownListener = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            guiController.move(EDirection.DOWN);
        }
    };

    AbstractAction onUpListener = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            guiController.move(EDirection.UP);
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
