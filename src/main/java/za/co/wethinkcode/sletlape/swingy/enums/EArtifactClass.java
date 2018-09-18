package za.co.wethinkcode.sletlape.swingy.enums;

import lombok.Getter;

public enum  EArtifactClass {
    Shank(15),
    Gun(50),
    Taser(30);

    @Getter
    int attack;

    EArtifactClass(int attack){
        this.attack = attack;
    }
}
