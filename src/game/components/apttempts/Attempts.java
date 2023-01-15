package game.components.apttempts;

import javax.swing.*;

public class Attempts extends JButton {
    int value;
    public Attempts(int value){
        super(Integer.toString(value));
        this.value = value;
        CreateAttempts();
    }

    public void  CreateAttempts(){

    }
}