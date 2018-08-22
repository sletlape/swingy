package view.gui;

import model.LivingElements.Hero;
import model.LivingElements.LiveEntity;
import model.LivingElements.Villain;
import model.mapElements.WorldMap;

import javax.swing.*;
import java.awt.*;

public class MapPanel extends JPanel {

    void generateMap(int mapSize) {

        this.setLayout(new GridLayout(mapSize, mapSize));

        for (int y = 0; y < mapSize; y++) {
            for (int x = 0; x < mapSize; x++) {
                add(new MapCell());
            }
        }
    }

    public void updateValues(WorldMap worldMap) {
        Point point = new Point();
        int count = 0;
        for (int y = 0; y < worldMap.getSize(); y++) {
            for (int x = 0; x < worldMap.getSize(); x++) {
                point.x = x;
                point.y = y;
                LiveEntity player = worldMap.getMap().get(point);
                MapCell mapCell = (MapCell) getComponent(count++);

                if (player == null)
                    mapCell.setValues("");
                else if (player instanceof Hero)
                    mapCell.setValues("H");
                else if (player instanceof Villain)
                    mapCell.setValues("V");
            }
        }
    }

    private class MapCell extends JPanel{
        JLabel label = new JLabel();

        public MapCell() {
            setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.GREEN));
            add(label);
        }

        public void setValues(String text) {
            label.setText(text);
        }
    }
}
