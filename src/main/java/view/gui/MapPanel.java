package view.gui;

import model.LivingElements.Hero;
import model.LivingElements.LiveEntity;
import model.LivingElements.Villain;
import model.mapElements.Arena;
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

    public void updateValues(Arena arena) {
        Point point = new Point();
        WorldMap worldMap = arena.getWorldMap();
        int count = 0;
        for (int y = 0; y < worldMap.getSize(); y++) {
            for (int x = 0; x < worldMap.getSize(); x++) {
                point.x = x;
                point.y = y;
                LiveEntity player = worldMap.getMap().get(point);
                MapCell mapCell = (MapCell) getComponent(count++);

                if (player == null) {
                    mapCell.setValues("");
                    mapCell.setBackground(Color.gray);
                }else if (player instanceof Villain && player.getPoint().equals(arena.getHero().getPoint())) {
                    mapCell.setValues("*");
                    mapCell.setBackground(Color.orange);
                }else if (player instanceof Hero) {
                    mapCell.setValues("H");
                    mapCell.setBackground(Color.green);
                }else if (player instanceof Villain){
                    mapCell.setValues("V");
                    mapCell.setBackground(Color.red);
                }
                if (y >= worldMap.getSize() || x >= worldMap.getSize())
                    arena.setGameOver(true);
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
