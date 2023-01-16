package game.main_game;

import game.main_game.buttons.MainButton;
import state.Components;
import state.State;

import javax.swing.*;
import java.awt.*;

public class LoadMainGame extends JPanel {
    public LoadMainGame(){
        CreateMainGame();
    }

    public void CreateMainGame(){
        this.setLayout(new GridLayout(State.GAME_WIDTH, State.GAME_HEIGHT));

        for (int i = 0; i< State.GAME_WIDTH; i++) {
            for (int j = 0; j < State.GAME_HEIGHT; j++) {
                this.add( Components.Buttons[i][j]);
                State.SUM+=Integer.parseInt(Components.Buttons[i][j].getText());
            }
        }
        Components.SUM_BUTTON.setText(Integer.toString(State.SUM));
    }
}
