package settings.section.controler.button;

import game.Game;
import game.components.next_operation.NextOperation;
import state.Components;
import state.State;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Save extends JButton implements ActionListener {

    public Save(){
        super("SAVE");
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        State.SUM = 0;
        State.GAME_HEIGHT = Integer.parseInt(Components.ROW_FIELD.getText());
        State.GAME_WIDTH = Integer.parseInt(Components.COLUMN_FIELD.getText());
        State.TARGET = Integer.parseInt(Components.TARGET_FIELD.getText());
        State.ATTEMPTS = Integer.parseInt(Components.ATTEMPTS_FIELD.getText());

        Components.TARGET_BUTTON.setText(Integer.toString(State.TARGET));
        Components.ATTEMPTS_BUTTON.setText(Integer.toString(State.ATTEMPTS));

        State.OPERATION = State.generateOperation(State.ATTEMPTS);

        Components.Buttons = new JButton[State.GAME_WIDTH][State.GAME_HEIGHT];

        Components.NEXT_OPERATION = new NextOperation();
        Components.GAME_PAGE = new Game();
    }
}