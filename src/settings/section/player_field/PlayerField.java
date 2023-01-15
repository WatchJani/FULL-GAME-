package settings.section.player_field;

import state.Components;
import state.State;

import javax.swing.*;
import java.awt.*;

public class PlayerField extends JPanel{

    public PlayerField(){
        CreatePlayerField();
    }
    public void CreatePlayerField(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(500, 80));
        JLabel SIZE_OF_THE_PLAYING_FIELD_LABEL = new JLabel("Choose a SIZE OF THE PLAYING FIELD");
        this.add(SIZE_OF_THE_PLAYING_FIELD_LABEL);

        JLabel COLUMN_LABEL = new JLabel("Column:");
        JLabel ROW_LABEL = new JLabel("Row:");

        JPanel FIELD_PANEL = new JPanel();

        FIELD_PANEL.add(COLUMN_LABEL);

        Components.ROW_FIELD.setText(Integer.toString(State.GAME_HEIGHT));

        FIELD_PANEL.add(Components.ROW_FIELD);
        FIELD_PANEL.add(ROW_LABEL);

        Components.COLUMN_FIELD.setText(Integer.toString(State.GAME_WIDTH));
        FIELD_PANEL.add(Components.COLUMN_FIELD);
        FIELD_PANEL.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.add(FIELD_PANEL);
    }
}