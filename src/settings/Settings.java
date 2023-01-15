package settings;

import settings.section.controler.Controler;
import settings.section.dificulty.Dificulty;
import settings.section.number_of_moves.NumberOfMoves;
import settings.section.player_field.PlayerField;
import settings.section.target_value_setting.TargetValueSetting;

import javax.swing.*;
import java.awt.*;

public class Settings extends JPanel {
    public Settings(){
        CreateSettings();
    }

    public void CreateSettings(){
        JPanel Container = new JPanel();
        Container.setPreferredSize(new Dimension(500, 500));//cetralni container

        //SECTION
        //Dificulty
        JPanel DIFFICULTY = new Dificulty();
        Container.add(DIFFICULTY);
        //Player Field
        JPanel PLAYER_FIELD = new PlayerField();
        Container.add(PLAYER_FIELD);
        //Number of Moves
        JPanel NUMBER_OF_MOVES = new NumberOfMoves();
        Container.add(NUMBER_OF_MOVES);
        //Target Value Setting
        JPanel TARGET_VALUE_SETTING = new TargetValueSetting();
        Container.add(TARGET_VALUE_SETTING);
        //Controler
        JPanel CONTROLER = new Controler();
        Container.add(CONTROLER);

        this.add(Container);
    }
}