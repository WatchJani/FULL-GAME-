package game.components.sum;

import javax.swing.*;
import java.awt.*;

public class Sum extends JButton {
    float value;
    public Sum(float value){
        super(Float.toString(value));
        this.value = value;
        CreateSum();
    }

    public void CreateSum(){

    }
}
