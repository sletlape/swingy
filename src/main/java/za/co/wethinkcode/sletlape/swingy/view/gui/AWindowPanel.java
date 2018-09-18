package za.co.wethinkcode.sletlape.swingy.view.gui;

import za.co.wethinkcode.sletlape.swingy.model.mapElements.Arena;

import javax.swing.*;

public abstract class AWindowPanel extends JPanel {
    abstract void updatePanel(Arena arena);
}
