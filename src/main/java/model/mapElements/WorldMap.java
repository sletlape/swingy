package model.mapElements;

import lombok.Getter;
import lombok.Setter;
import model.LivingElements.LiveEntity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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