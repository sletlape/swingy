package za.co.wethinkcode.sletlape.swingy.controller.Entity;

import za.co.wethinkcode.sletlape.swingy.factory.VillainFactory;
import za.co.wethinkcode.sletlape.swingy.model.LivingElements.LiveEntity;
import za.co.wethinkcode.sletlape.swingy.model.mapElements.WorldMap;
import za.co.wethinkcode.sletlape.swingy.utils.Formulas;

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
        ArrayList<LiveEntity> randomVillain = VillainFactory.randomVillain(mapSize);
        addObjects(randomVillain);
    }

    private void addObjects(ArrayList<LiveEntity> objects) {
        for (LiveEntity liveEntity : objects)
            addObject(liveEntity);
    }

    public void addObject(LiveEntity entity) {
        map.put(entity.getPoint(), entity);
    }

    public void removeObject(Point point) {
        map.remove(point);
    }

    public boolean containsEnemy(Point newPoint) {
        return map.get(newPoint) != null;
    }

    public LiveEntity getObject(Point heroPoint) {
        return map.get(heroPoint);
    }
}