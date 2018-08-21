package controller.Entity;

import model.LivingElements.LiveEntity;
import model.mapElements.WorldMap;
import utils.Formulas;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class MapController {
    WorldMap worldMap;
    HashMap<Point, LiveEntity> map;

    public void initializeMap(WorldMap worldMap, int heroLevel){
        this.worldMap = worldMap;
        this.map = worldMap.getMap();

        worldMap.getMap().clear();

        int mapSize = Formulas.getMapSize(heroLevel);
        worldMap.setSize(mapSize);
    }

    public void addObject(LiveEntity entity) {
        map.put(entity.getPoint(), entity);
    }

    public void removeObject(Point point) {
        map.remove(point);
    }
}
