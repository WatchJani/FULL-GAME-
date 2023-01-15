package settings.section.controler;

import settings.section.controler.button.Back;
import settings.section.controler.button.Save;

import javax.swing.*;
import java.awt.*;

public class Controler extends JPanel {
    public Controler(){
        CreateControler();
    }

    public void CreateControler(){
        this.setPreferredSize(new Dimension(500, 80));
        JButton BACK = new Back();
        JButton SAVE = new Save();
        this.add(BACK);
        this.add(SAVE);
    }
}