package view.gui;

import model.mapElements.Arena;

import javax.swing.*;

public class MenuPanel extends IWindowPanel {
    JLabel lblWelcome = new JLabel("<html><h1>Welcome to Swingy-prison break!<h1><br />");
    JButton btnNewHero = new JButton("Create New Hero");
    JButton btnLoadHero = new JButton("Load Hero");

    public MenuPanel() {
        //this.setLayout(null);
        //lblWelcome.setBounds(220, 20, 180, 50);
        //btnNewHero.setBounds(60, 100,60,20);
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
}
