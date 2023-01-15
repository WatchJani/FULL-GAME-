import state.Components;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame(){
        SuperFrame();
    }

    public void SuperFrame(){
        JFrame frame = new JFrame("More or less less is more");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 720);

        //sve ostalo ici

        frame.add(Components.MENU_PAGE);

        frame.setVisible(true);
    }
}
