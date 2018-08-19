package controller.Interfacing;

import com.sun.tools.internal.xjc.reader.gbind.Graph;
import view.Gui;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class GUIController extends AbstractInterfaceController implements Runnable {

    public int width, height;
    private Gui userInterface;

    private Thread thread;
    private boolean running = false;

    private BufferStrategy bs;
    private Graphics g;

    //video calls this Game
    GUIController(){
        this.width = 800;
        this.height = 600;
    }

    public synchronized void start(){
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        if (!running)
            return;
        running = false;
        try {
            thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }


    private void guiInit() {
        userInterface  = new Gui();
    }

    private void updateGui() {
    }

    private void renderGui() {
        bs = userInterface.getCanvas().getBufferStrategy();
        if (bs == null){
            userInterface.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        //Clear screen
        g.clearRect(0,0, width, height);
        //Draw here
        g.drawRect(10, 50, 50, 70);
        //End draw
        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        //initializes graphics
        guiInit();
        //game loop
        while (running){
            updateGui();
            renderGui();
        }
    }



    @Override
    void switchUI() {}

}
