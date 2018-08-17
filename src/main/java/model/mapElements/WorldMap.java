package model.mapElements;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter @Setter
public class WorldMap {

    ArrayList map;
    int size;

    public WorldMap(){
        this.size = 0;
        this.map = new ArrayList();
    }
}
