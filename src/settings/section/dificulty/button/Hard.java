package settings.section.dificulty.button;

import game.Game;
import game.components.next_operation.NextOperation;
import state.Components;
import state.State;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hard extends JButton implements ActionListener {

    public Hard(){
        super("HARD");
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        State.SUM = 0;
        State.GAME_HEIGHT =20;
        State.GAME_WIDTH = 20;
        State.TARGET = (int)(State.GAME_HEIGHT *   State.GAME_WIDTH * 9 / 1.8);
        State.ATTEMPTS = 15;

        Components.TARGET_BUTTON.setText(Integer.toString(State.TARGET));
        Components.ATTEMPTS_BUTTON.setText(Integer.toString(State.ATTEMPTS));

        State.OPERATION = State.generateOperation(State.ATTEMPTS);

        Components.Buttons = new JButton[State.GAME_WIDTH][State.GAME_HEIGHT];

        Components.NEXT_OPERATION = new NextOperation();
        Components.GAME_PAGE = new Game();

        Components.TARGET_FIELD.setText(Integer.toString(State.TARGET));
        Components.ATTEMPTS_FIELD.setText(Integer.toString(State.ATTEMPTS));
        Components.ROW_FIELD.setText(Integer.toString(State.GAME_HEIGHT));
        Components.COLUMN_FIELD.setText(Integer.toString(State.GAME_WIDTH));

    }
}
