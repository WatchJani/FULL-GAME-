package game.components.save_and_back;

import state.Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveAndBack extends JButton implements ActionListener {
    public SaveAndBack(){
        super("QUIT");
        this.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int odgovor = JOptionPane.showOptionDialog(null, "Da li ste sigurni?", "Potvrda", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (odgovor == JOptionPane.YES_OPTION) {
            // kod koji se izvršava ako korisnik klikne na "Da"
        } else {
            Container parent = this.getParent();
            Container grandParent = parent.getParent();
            Container grandGrandParent = grandParent.getParent();
            grandGrandParent.removeAll();
            grandGrandParent.revalidate();
            grandGrandParent.repaint();

            grandGrandParent.add(Components.MENU_PAGE);
        }
    }
}