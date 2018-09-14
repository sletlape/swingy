package view.gui;

import lombok.Getter;
import model.LivingElements.Hero;
import model.mapElements.Arena;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.util.ArrayList;
import java.util.Enumeration;

public class AvatarPanel extends AWindowPanel {
    JTextField txfProfileName = new JTextField(25);
    JButton btnSubmit = new JButton("Submit");

    ButtonGroup bg = new ButtonGroup();

    public AvatarPanel(ArrayList<Hero> heroes, boolean isFromDatabase) {

        txfProfileName.setVisible(!isFromDatabase);
        txfProfileName.setDocument(new JTextFieldLimit(20));
        txfProfileName.setBounds(150, 10, 25, 300);

        this.add(txfProfileName);
        int i = 0;
        for (Hero hero : heroes){
            CustomRadioButton button = new CustomRadioButton(hero.getName(), i++);
            bg.add(button);
            this.add(button);

        }


        //Button group for radio buttons



        btnSubmit.setBounds(100,150,100,30);
        this.add(btnSubmit);
    }

    @Override
    void updatePanel(Arena arena) {

    }


//    public void actionPerformed(ActionEvent e){
//        //send the respective options to their classes
//        if (rbtnMichael.isSelected()){
//            JOptionPane.showMessageDialog(this, "You Selected Michael.");
//        }
//        if (rbtnLincoln.isSelected()){
//            JOptionPane.showMessageDialog(this, "You Selected Lincoln.");
//        }
//        if (rbtnFernando.isSelected()){
//            JOptionPane.showMessageDialog(this, "You Selected Fernando.");
//        }
//    }

    public void addSelectListener(AbstractAction bgListener) {
        for (Enumeration<AbstractButton> buttons = bg.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            button.addActionListener(bgListener);
        }
    }

    public void addBtnSubmitListener(AbstractAction newHeroListener) {
        btnSubmit.addActionListener(newHeroListener);
    }

    public void addTxtPlayerNameDocumentListener(DocumentListener documentListener)
    {
        txfProfileName.getDocument().addDocumentListener(documentListener);
    }

    public class CustomRadioButton extends JRadioButton {
        @Getter
        private int tag;

        public CustomRadioButton(String name, int tag) {
            this.tag = tag;
            this.setText(name);


        }
    }

//    public void addBtnDatabaseListener(AbstractAction fetchDatabaseListener) {
//        btnLoadHero.addActionListener(fetchDatabaseListener);
//    }
}
