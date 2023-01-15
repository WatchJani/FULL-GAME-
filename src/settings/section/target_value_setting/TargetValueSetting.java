package settings.section.target_value_setting;

import state.Components;
import state.State;

import javax.swing.*;
import java.awt.*;

public class TargetValueSetting extends JPanel {
    public TargetValueSetting(){
        CreateTargetValueSetting();
    }

    public void CreateTargetValueSetting(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(500, 80));
        JLabel TARGET_VALUE_SETTING_LABEL = new JLabel("Choose a TARGET VALUE SETTING");
        this.add(TARGET_VALUE_SETTING_LABEL);


        JPanel TARGET_VALUE_SETTING_PANEL = new JPanel();

        Components.TARGET_FIELD.setText(Integer.toString(State.TARGET));

        TARGET_VALUE_SETTING_PANEL.add(Components.TARGET_FIELD);

        TARGET_VALUE_SETTING_PANEL.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.add(TARGET_VALUE_SETTING_PANEL);
    }
}