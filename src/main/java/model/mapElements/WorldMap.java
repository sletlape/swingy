package model.mapElements;

import lombok.Getter;
import lombok.Setter;
import model.LivingElements.LiveEntity;

import javax.swing.text.html.parser.Entity;
import javax.xml.ws.AsyncHandler;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

@Getter @Setter
public class WorldMap {

    HashMap<Point, LiveEntity> map;
    int size;

    public WorldMap(){
        this.size = 0;
        map = new HashMap<>();
    }
}