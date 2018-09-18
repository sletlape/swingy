package za.co.wethinkcode.sletlape.swingy.model.mapElements;

import lombok.Getter;
import lombok.Setter;
import za.co.wethinkcode.sletlape.swingy.model.LivingElements.Hero;
import za.co.wethinkcode.sletlape.swingy.model.LivingElements.Villain;
import za.co.wethinkcode.sletlape.swingy.model.util.GameMessages;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Setter
@Getter
public class Arena {
//
//    @Id
//    @Column(updatable = false, nullable = false, length = 100)
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    WorldMap worldMap;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    GameMessages gameMessages = new GameMessages();

    public Arena(WorldMap worldMap, ArrayList<Villain> villains) {
        this.worldMap = worldMap;
        this.villains = villains;
    }

    public Arena() {
    }
}