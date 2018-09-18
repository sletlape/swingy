package za.co.wethinkcode.sletlape.swingy.model.mapElements;

import lombok.Getter;
import lombok.Setter;
import za.co.wethinkcode.sletlape.swingy.model.LivingElements.LiveEntity;

import java.awt.*;
import java.util.HashMap;

@Getter @Setter
public class    WorldMap {
//
//    @Id
//    @Column(updatable = false, nullable = false, length = 100)
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    HashMap<Point, LiveEntity> map;
    int size;

    public WorldMap(){
        this.size = 0;
        map = new HashMap<>();
    }
}