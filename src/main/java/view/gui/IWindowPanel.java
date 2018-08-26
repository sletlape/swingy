package view.gui;

import model.mapElements.Arena;

import javax.swing.*;

public abstract class IWindowPanel extends JPanel {
    abstract void updatePanel(Arena arena);
}
