package menu.button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exit extends JButton implements ActionListener {

    public Exit(String text){
        super(text);
        this.addActionListener(this);
        CreateButton();
    }

    public void CreateButton(){
        this.setPreferredSize(new Dimension(250, 70));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}