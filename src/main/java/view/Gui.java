package view;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter @Setter
public class Gui {

    private JFrame frame;
    private Canvas canvas;

    private int size = 300;

    public  Gui(){
        drawGui();
    }

    private void drawGui() {
        frame = new JFrame("Swingy");
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