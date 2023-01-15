package settings.section.number_of_moves;

import state.Components;
import state.State;

import javax.swing.*;
import java.awt.*;

public class NumberOfMoves extends JPanel {
    public NumberOfMoves(){
        CreateNumberOfMoves();
    }

    public void CreateNumberOfMoves(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(500, 80));
        JLabel NUMBER_OF_MOVES_LABEL = new JLabel("Choose a NUMBER OF MOVES");
        this.add(NUMBER_OF_MOVES_LABEL);

        JPanel NUMBER_OF_MOVES_PANEL = new JPanel();

        Components.ATTEMPTS_FIELD.setText(Integer.toString(State.ATTEMPTS));

        NUMBER_OF_MOVES_PANEL.add(Components.ATTEMPTS_FIELD);

        NUMBER_OF_MOVES_PANEL.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.add(NUMBER_OF_MOVES_PANEL);
    }
}