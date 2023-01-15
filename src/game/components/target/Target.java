package game.components.target;

import javax.swing.*;

public class Target extends JButton {
    int value;
    public Target(int value){
        super(Integer.toString(value));
        this.value = value;
        CreateTarget();
    }

    public void CreateTarget(){

    }
}