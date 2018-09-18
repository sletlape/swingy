package za.co.wethinkcode.sletlape.swingy.model.LivingElements;

import za.co.wethinkcode.sletlape.swingy.enums.EArtifactClass;

public class Villain extends LiveEntity {

    public Villain(String name, int hp, int xp, EArtifactClass artifactClass) {
        super(name, hp, xp, 0);
        this.artifactClass = artifactClass;
    }
}
