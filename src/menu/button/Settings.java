package menu.button;

import state.Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JButton implements ActionListener {

    public Settings(String text){
        super(text);
        this.addActionListener(this);
        CreateButton();
    }

    public void CreateButton(){
        this.setPreferredSize(new Dimension(250, 70));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Delete all from menu
        Container parent = this.getParent();
        Container grandParent = parent.getParent();
        Container grandGrandParent = grandParent.getParent();
        grandGrandParent.removeAll();
        grandGrandParent.revalidate();
        grandGrandParent.repaint();

        //new screen
        grandGrandParent.add(Components.SETTINGS_PAGE);
    }
}