package controller;

public class InterfaceController {
    protected String    userName;
    protected String    avatarType;
    protected int       xp;

    public InterfaceController(String userName, String avatarType, int xp){
        this.userName = userName;
        this.avatarType = avatarType;
        this.xp = xp;
    }

    /*Store all values in variables then pass the variable to GUI or CLI*/
}
