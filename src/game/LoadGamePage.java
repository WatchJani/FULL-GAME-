package game;

import game.components.next_operation.NextOperation;
import game.main_game.LoadMainGame;
import game.main_game.MainGame;
import state.Components;

import javax.swing.*;
import java.awt.*;

public class LoadGamePage extends JPanel {
    public LoadGamePage(){
        CreateGame();
    }
    public void CreateGame(){
        this.setLayout(new BorderLayout());

        JPanel CENTER_PANEL = new JPanel();
        CENTER_PANEL.setLayout(new BorderLayout());

        JPanel MAIN_GAME = new LoadMainGame();
        CENTER_PANEL.add(MAIN_GAME, BorderLayout.CENTER);
        JPanel NEXT_OPERATION = new NextOperation();
        CENTER_PANEL.add(NEXT_OPERATION, BorderLayout.EAST);

        //NORTH
        JPanel NORTH_PANEL = new JPanel();
        NORTH_PANEL.setLayout(new BorderLayout());
        NORTH_PANEL.add(Components.QUIT_BUTTON, BorderLayout.WEST);
        NORTH_PANEL.add(Components.TARGET_BUTTON, BorderLayout.CENTER);
        NORTH_PANEL.add(Components.ATTEMPTS_BUTTON, BorderLayout.EAST);


        this.add(CENTER_PANEL, BorderLayout.CENTER);
        this.add(NORTH_PANEL, BorderLayout.NORTH);
        this.add(Components.SUM_BUTTON, BorderLayout.SOUTH);
    }
}
