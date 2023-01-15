package game;

import game.components.apttempts.Attempts;
import game.components.next_operation.NextOperation;
import game.components.save_and_back.SaveAndBack;
import game.components.sum.Sum;
import game.components.target.Target;
import game.main_game.MainGame;
import state.Components;

import javax.swing.*;
import java.awt.*;

public class Game extends JPanel {
    public Game(){
        CreateGame();
    }

    public void CreateGame(){
        this.setLayout(new BorderLayout());

        JPanel CENTER_PANEL = new JPanel();
        CENTER_PANEL.setLayout(new BorderLayout());

        JPanel MAIN_GAME = new MainGame();
        CENTER_PANEL.add(MAIN_GAME, BorderLayout.CENTER);
        CENTER_PANEL.add(Components.NEXT_OPERATION, BorderLayout.EAST);

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