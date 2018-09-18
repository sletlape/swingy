package za.co.wethinkcode.sletlape.swingy.view.gui;

import za.co.wethinkcode.sletlape.swingy.controller.Interfacing.GUIController;
import za.co.wethinkcode.sletlape.swingy.model.mapElements.Arena;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorldPanel extends AWindowPanel {

    Boolean gameOver = false;
    GUIController controller;

    MapPanel mapPanel = new MapPanel();
    JPanel fightOrFlight = new JPanel();
    TextArea statsText = new TextArea();

    JButton fight = new JButton("Fight");
    JButton flight = new JButton("Flight");

    private final int WIF = JComponent.WHEN_IN_FOCUSED_WINDOW;

    public WorldPanel(final Arena arena, final GUIController controller) {

        this.controller = controller;
        this.setLayout(new BorderLayout());
        statsText.setEditable(false);
        mapPanel.generateMap(arena.getWorldMap().getSize());
        this.add(mapPanel);
        this.add(statsText, BorderLayout.EAST);

        fightOrFlight.add(fight, BorderLayout.EAST);
        fightOrFlight.add(flight, BorderLayout.WEST);

        this.add(fightOrFlight, BorderLayout.SOUTH);

        fightOrFlight.setVisible(true);

        fightOrFlight(arena, controller);

        updatePanel(arena);
    }

    private void fightOrFlight(final Arena arena, final GUIController controller) {
        fight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arena.isInFight())
                    controller.performFight();
            }
        });

        flight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arena.isInFight())
                    controller.performFlight();
            }
        });
    }

    public void updatePlayerStats(Arena arena){

        int border = arena.getWorldMap().getSize();
        Point heroPosition = arena.getHero().getPoint();

        if (arena.isGameOver()){
            if (heroPosition.y+1 >= border || heroPosition.x+1 >= border)
                statsText.setText("Congratulations, You have reached the wall");
        } else {
            if (arena.getHero().getHp() > 0)
                statsText.setText(arena.getHero().toString());
            else {
                statsText.setText("Your HP is 0, You lost");
                arena.setGameOver(true);
            }
        }
    }

    @Override
    void updatePanel(Arena arena) {
        mapPanel.updateValues(arena);
        updatePlayerStats(arena);
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
