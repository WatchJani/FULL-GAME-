package settings.section.controler.button;

import menu.Menu;
import settings.section.controler.Controler;
import state.Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Back extends JButton implements ActionListener {

    public Back(){
        super("BACK");
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Container parent = this.getParent();
        Container grandParent = parent.getParent();
        Container grandGrandParent = grandParent.getParent();
        Container root = grandGrandParent.getParent();
        root.removeAll();
        root.revalidate();
        root.repaint();

        //new screen
        root.add(Components.MENU_PAGE);
    }
}