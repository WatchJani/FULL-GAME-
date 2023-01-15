package settings.section.dificulty;

import settings.section.dificulty.button.Easy;
import settings.section.dificulty.button.Hard;
import settings.section.dificulty.button.Normal;

import javax.swing.*;
import java.awt.*;

public class Dificulty extends JPanel {
    public Dificulty(){
        CreateDificulty();
    }

    public void CreateDificulty(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(500, 80));
        JLabel DIFFICULTY_LABEL = new JLabel("Choose a difficulty!");
        this.add(DIFFICULTY_LABEL);

        JPanel PANEL_BUTTON = new JPanel();

        PANEL_BUTTON.add(new Easy());
        PANEL_BUTTON.add(new Normal());
        PANEL_BUTTON.add(new Hard());

        PANEL_BUTTON.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.add(PANEL_BUTTON);
    }

}