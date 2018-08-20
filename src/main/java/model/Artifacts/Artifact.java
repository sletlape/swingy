package model.Artifacts;

public class Artifact {

    private int     id;
    private String  name;
    private String  type;
    private int     power;

    public Artifact(){}

    public Artifact(String name, String type, int power){
        this.name = name;
        this.type = type;
        this.power = power;
    }
}
