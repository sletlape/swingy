package view.gui;

import model.mapElements.Arena;

import javax.swing.*;

public class MenuPanel extends AWindowPanel {
    JLabel lblWelcome = new JLabel("<html><h1>Welcome to Swingy-prison break!<h1><br />");
    JButton btnNewHero = new JButton("Create New Hero");
    JButton btnLoadHero = new JButton("Load Hero");

    public MenuPanel() {
        this.add(lblWelcome);
        this.add(btnNewHero);
        this.add(btnLoadHero);
    }

    @Override
    void updatePanel(Arena arena) {

    }

    public void addBtnNewHeroListener(AbstractAction newHeroListener) {
        btnNewHero.addActionListener(newHeroListener);
    }

    public void addBtnDatabaseListener(AbstractAction fetchDatabaseListener) {
        btnLoadHero.addActionListener(fetchDatabaseListener);
    }
}
