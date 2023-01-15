package game.main_game.buttons;

import state.Components;
import state.State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainButton extends JButton implements ActionListener {
    int x;
    int y;
    int value;

    public MainButton(int text, int x, int y){
        super(Integer.toString(text));
        this.value = text;
        this.x = x;
        this.y = y;
        this.addActionListener(this);
    }

    public int Mod(String operation){

        int res;

        if(operation.equals("+")){
            res = (Integer.parseInt(this.getText()) + Integer.parseInt(Components.Buttons[State.LAST_CLICK[0]][State.LAST_CLICK[1]].getText())) % 10;
        }else if(operation.equals("-")){
            res = (Integer.parseInt(Components.Buttons[State.LAST_CLICK[0]][State.LAST_CLICK[1]].getText()) - Integer.parseInt(this.getText())) % 10;
        }else if(operation.equals("*")){
            res = (Integer.parseInt(this.getText()) * Integer.parseInt(Components.Buttons[State.LAST_CLICK[0]][State.LAST_CLICK[1]].getText())) % 10;
        }else{
            res =  ( Integer.parseInt(Components.Buttons[State.LAST_CLICK[0]][State.LAST_CLICK[1]].getText()) / Integer.parseInt(this.getText()) ) % 10;
        }

        return res;
    }

    public void Click(){
        if(State.LAST_CLICK[0] != -1){
            Components.Buttons[State.LAST_CLICK[0]][State.LAST_CLICK[1]].setEnabled(true);

            int gameOperation = Mod("-");

            Components.Buttons[State.LAST_CLICK[0]][State.LAST_CLICK[1]].setText(
                    Integer.toString(gameOperation)
            );


            //POPRAVITI
            State.SUM+=gameOperation; // treba biti float, mislim da nije dobro da ima decimalni zarez
            Components.SUM_BUTTON.setText(Integer.toString(State.SUM));
        }

        this.setEnabled(false);

        State.ATTEMPTS--;
        Components.ATTEMPTS_BUTTON.setText(Integer.toString(State.ATTEMPTS));
        for (int row =0; row< State.GAME_WIDTH; row++){
            for(int column = 0; column<State.GAME_HEIGHT; column++){
                if(this.x != row && this.y != column){
                    Components.Buttons[row][column].setVisible(false);
                }
                if((this.x == row && !Components.Buttons[row][column].isVisible()) || (this.y == column && !Components.Buttons[row][column].isVisible())){
                    Components.Buttons[row][column].setVisible(true);
                }
            }
        }

        State.LAST_CLICK[0] = this.x;
        State.LAST_CLICK[1] = this.y;

        Components.NEXT_OPERATION.getComponent(1).setBackground(Color.GREEN);

        State.OPERATION.remove(0);
        Components.NEXT_OPERATION.remove(0);
        Components.NEXT_OPERATION.revalidate();
        Components.NEXT_OPERATION.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.Click();
    }
}
