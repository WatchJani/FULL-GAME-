package menu;

import state.Components;

import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel{
    public Menu(){
        CreateMenu();
    }

    public void CreateMenu(){
        JPanel Center = new JPanel();
        Center.setPreferredSize(new Dimension(500, 500));

        Center.add(Components.PLAY_BUTTON);
        Center.add(Components.SETTINGS_BUTTON);
        Center.add(Components.LOAD_BUTTON);
        Center.add(Components.EXIT_BUTTON);

        this.add(Center);
    }
}