package view.gui;

import model.mapElements.Arena;

import javax.swing.*;

public class MenuPanel extends IWindowPanel {
    JButton btnNewHero = new JButton("Create New Hero");
    JButton btnLoadHero = new JButton("Load Hero");
    public MenuPanel() {
        this.add(btnNewHero);
        this.add(btnLoadHero);
    }

    @Override
    void updatePanel(Arena arena) {

    }

    public void addBtnNewHeroListener(AbstractAction newHeroListener) {
        btnNewHero.addActionListener(newHeroListener);
    }
}
