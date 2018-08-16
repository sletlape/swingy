package view;

import javax.swing.*;

public class Gui {

    private JFrame frame;
    private String title;
    private int width, height;

    public  Gui(String title, int height, int width){
        this.title = title;
        this.height = height;
        this.width = width;

        createDisplay();
    }

    private void createDisplay() {
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
