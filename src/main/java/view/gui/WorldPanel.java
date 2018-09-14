package view.gui;

import model.LivingElements.Hero;
import model.mapElements.Arena;

import javax.swing.*;
import java.awt.*;

public class WorldPanel extends AWindowPanel {
    MapPanel mapPanel = new MapPanel();
    JPanel fightOrFlight = new JPanel();
    TextArea statsText = new TextArea();

    JButton fight = new JButton("Fight");
    JButton flight = new JButton("Flight");

    private final int WIF = JComponent.WHEN_IN_FOCUSED_WINDOW;

    public WorldPanel(Arena arena) {
        this.setLayout(new BorderLayout());
        statsText.setEditable(false);
        mapPanel.generateMap(arena.getWorldMap().getSize());
        this.add(mapPanel);
        this.add(statsText, BorderLayout.EAST);

        fightOrFlight.add(fight, BorderLayout.EAST);
        fightOrFlight.add(flight, BorderLayout.WEST);
        this.add(fightOrFlight, BorderLayout.SOUTH);

        fightOrFlight.setVisible(true);

        updatePanel(arena);
    }


    public void updatePlayerStats(Hero hero){
        statsText.setText(hero.toString());
    }

    @Override
    void updatePanel(Arena arena) {
        mapPanel.updateValues(arena);
        updatePlayerStats(arena.getHero());
    }

    public void addOnUpListener(AbstractAction onUpListener) {
        final String KEY_BINDING_MOVE_UP = "move up";
        this.getInputMap(WIF).put(KeyStroke.getKeyStroke("W"), KEY_BINDING_MOVE_UP);
        this.getActionMap().put(KEY_BINDING_MOVE_UP,  onUpListener);
    }

    public void addOnDownListener(AbstractAction onDownListener) {
        final String KEY_BINDING_MOVE_DOWN = "move down";
        this.getInputMap(WIF).put(KeyStroke.getKeyStroke("S"), KEY_BINDING_MOVE_DOWN);
        this.getActionMap().put(KEY_BINDING_MOVE_DOWN, onDownListener);
    }

    public void addOnLeftListener(AbstractAction onLeftListener) {
        mapPanel.getInputMap(WIF).put(KeyStroke.getKeyStroke("A"), "OnLeft");
        mapPanel.getActionMap().put("OnLeft",  onLeftListener);
    }

    public void addOnRightListener(AbstractAction onRightListener) {
        mapPanel.getInputMap(WIF).put(KeyStroke.getKeyStroke("D"), "OnRight");
        mapPanel.getActionMap().put("OnRight",  onRightListener);
    }
}
