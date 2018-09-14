package view.gui;

import model.mapElements.Arena;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AvatarPanel extends AWindowPanel implements ActionListener {
    JTextField txfProfileName = new JTextField(25);
    JRadioButton rbtnLincoln = new JRadioButton("Lincoln");
    JRadioButton rbtnMichael = new JRadioButton("Michael");
    JRadioButton rbtnFernando = new JRadioButton("Fernando");
    JButton btnSubmit = new JButton("Submit");

    ButtonGroup bg = new ButtonGroup();

    public AvatarPanel() {


        txfProfileName.setDocument(new JTextFieldLimit(20));
        txfProfileName.setBounds(150, 10, 25, 300);
        rbtnFernando.setBounds(75, 30, 100, 30);
        rbtnLincoln.setBounds(75, 50, 100, 30);
        rbtnMichael.setBounds(75, 70, 100, 30);

        this.add(txfProfileName);

        bg.add(rbtnLincoln);
        bg.add(rbtnMichael);
        bg.add(rbtnFernando);

        this.add(rbtnLincoln);
        this.add(rbtnMichael);
        this.add(rbtnFernando);

        btnSubmit.setBounds(100,150,100,30);
        btnSubmit.addActionListener(this);
        this.add(btnSubmit);

    }

    @Override
    void updatePanel(Arena arena) {

    }

    public void actionPerformed(ActionEvent e){

        if (rbtnMichael.isSelected()){
            JOptionPane.showMessageDialog(this, "You Selected Michael.");
        }
        if (rbtnLincoln.isSelected()){
            JOptionPane.showMessageDialog(this, "You Selected Lincoln.");
        }
        if (rbtnFernando.isSelected()){
            JOptionPane.showMessageDialog(this, "You Selected Fernando.");
        }
    }

    public void addBtnNewHeroListener(AbstractAction newHeroListener) {
        rbtnLincoln.addActionListener(newHeroListener);
    }

    public void addBtnSubmitListener(AbstractAction newHeroListener) {
        btnSubmit.addActionListener(newHeroListener);
    }

//    public void addBtnDatabaseListener(AbstractAction fetchDatabaseListener) {
//        btnLoadHero.addActionListener(fetchDatabaseListener);
//    }
}
