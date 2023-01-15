package menu.button;

import game.Game;
import state.Components;
import state.State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start extends JButton implements ActionListener {

    public Start(String text){
        super(text);
        this.addActionListener(this);
        CreateButton();
    }

    public void CreateButton(){
        this.setPreferredSize(new Dimension(250, 70));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        State.SUM = 0;
        Container parent = this.getParent();
        Container grandParent = parent.getParent();
        Container grandGrandParent = grandParent.getParent();
        grandGrandParent.removeAll();
        grandGrandParent.revalidate();
        grandGrandParent.repaint();

        JPanel GAME_PAGE = new Game();
        grandGrandParent.add(GAME_PAGE);
    }
}