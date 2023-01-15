package game.main_game;

import game.main_game.buttons.MainButton;
import state.Components;
import state.State;

import javax.swing.*;
import java.awt.*;


public class MainGame extends JPanel {

    public MainGame(){
        CreateMainGame();
    }

    public void CreateMainGame(){
        this.setLayout(new GridLayout(State.GAME_WIDTH, State.GAME_HEIGHT));

        for (int i = 0; i< State.GAME_WIDTH; i++) {
            for (int j = 0; j < State.GAME_HEIGHT; j++) {
                int myRandomNumber = (int) (Math.random() * 10);
                Components.Buttons[i][j] = new MainButton(myRandomNumber, i, j);
                Components.Buttons[i][j].setBackground(Color.white);
                this.add( Components.Buttons[i][j]);
                State.SUM+=myRandomNumber;
            }
        }
        Components.SUM_BUTTON.setText(Integer.toString(State.SUM));
    }
}