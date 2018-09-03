package model.LivingElements;

import enums.EArtifactClass;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.awt.*;

@Entity
@Getter @Setter
public abstract class LiveEntity {
    @Id
    @Column(updatable = false, nullable = false, length = 100)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Username cannot be null")
    @Size(min = 3, max = 10, message = "Username should be between 3 and 10 characters long!")
    protected String name;

    protected int hp;
    protected int xp;
    protected int level;

    EArtifactClass artifactClass;

    @Transient
    protected Point point;

    public LiveEntity(String name, int hp, int xp, int level) {
        this.name = name;
        this.hp = hp;
        this.xp = xp;
        this.level = level;
        this.point = new Point();

    }

    protected LiveEntity() {
    }
}