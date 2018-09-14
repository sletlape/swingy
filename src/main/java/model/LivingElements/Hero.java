package model.LivingElements;

import enums.EArtifactClass;
import enums.EHeroClass;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.awt.*;

@Entity
@Getter
@Setter
public class Hero extends LiveEntity{
    @Id
    @Column(updatable = false, nullable = false, length = 100)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    EHeroClass heroClass;

    @Transient
    Point lastPoint = null;

    @Override
    public String toString() {
        return "Hero{" +
                "\n id=" + id +
                "\n heroClass = " + heroClass +
                "\n name = " + name + '\'' +
                "\n hp =" + hp +
                "\n xp = " + xp +
                "\n level = " + level +
                "\n artifactClass = " + artifactClass +
                '}';
    }

    public Hero(String name, EHeroClass heroClass, EArtifactClass artifactClass) {
        super(name, 100, 1, 1);
        this.heroClass = heroClass;
        this.artifactClass = artifactClass;
        this.lastPoint = this.point;
    }

    protected Hero() {
        super();
    }
}
