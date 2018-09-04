package model.mapElements;

import lombok.Getter;
import lombok.Setter;
import model.LivingElements.Hero;
import model.LivingElements.Villain;
import model.util.GameMessages;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Setter
@Getter
public class Arena {

    @Id
    @Column(updatable = false, nullable = false, length = 100)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Transient
    WorldMap worldMap;


    @Transient
    ArrayList<Villain> villains;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    Hero hero;

    @Type(type = "yes_no")
    boolean isInFight = false;

    @Transient
    boolean wasInfight = false;

    @Type(type = "yes_no")
    boolean isGameOver = false;

    @Type(type = "yes_no")
    boolean isValidPlayerName = false;

    @Transient
    GameMessages gameMessages = new GameMessages();

    public Arena(WorldMap worldMap, ArrayList<Villain> villains) {
        this.worldMap = worldMap;
        this.villains = villains;
    }

    public Arena() {
    }
}