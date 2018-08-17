package controller;

import view.Gui;

public class GUIController extends AbstractInterfaceController{

    Gui userInterface;


    @Override
    void run() {
        userInterface  = new Gui();
    }

    @Override
    void switchUI() {}
}
