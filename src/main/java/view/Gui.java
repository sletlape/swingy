package view;

import javax.swing.*;

public class Gui {

    private JFrame frame;
    private String title = "Swingy";
    private int size = 300;

    public  Gui(){
        createDisplay();
    }

    private void createDisplay() {
        frame = new JFrame(title);
        frame.setSize(size, size);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}