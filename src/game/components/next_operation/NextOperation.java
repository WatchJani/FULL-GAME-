package game.components.next_operation;

import game.components.next_operation.button.OperationButton;
import state.State;

import javax.swing.*;
import java.awt.*;

public class NextOperation extends JPanel {
    public NextOperation(){
        CreateNextOperation();
    }

    public void CreateNextOperation(){
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(50, 500));

        JButton OPERATION[] = new OperationButton[State.OPERATION.size()];
        for (int i = 0; i< State.OPERATION.size(); i++){
            OPERATION[i] = new OperationButton(State.OPERATION.get(i));
            this.add(OPERATION[i]);
        }

        OPERATION[0].setBackground(Color.GREEN);
    }
}