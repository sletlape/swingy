package view;

import controller.CLIMainController;

public class Cli implements UserInterface{
    public Cli(){
        new CLIMainController("manny","ang",0);
    }

    public void updateSize() {

    }
}
