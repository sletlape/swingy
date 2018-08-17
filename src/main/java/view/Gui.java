package view;

import javax.swing.*;
import java.awt.*;

public class Gui {

    private JFrame frame;
    private Canvas canvas;

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

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(size, size));
        canvas.setMaximumSize(new Dimension(size, size));
        canvas.setMinimumSize(new Dimension(size, size));

        frame.add(canvas);
        frame.pack();
    }
}