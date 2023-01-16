package game.main_game.buttons;

import game.Game;
import game.components.next_operation.NextOperation;
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
            if(Integer.parseInt(this.getText()) != 0){
                res =  ( Integer.parseInt(Components.Buttons[State.LAST_CLICK[0]][State.LAST_CLICK[1]].getText()) / Integer.parseInt(this.getText()) ) % 10;
            }else{
                res = 0;
            }
        }
        return res;
    }

    public void Click(){
        if(State.ATTEMPTS == State.SUM){
            String[] opcije = {"OK"};
            int odabir = JOptionPane.showOptionDialog(null, "WIN", "END", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcije, opcije[0]);
            if (odabir ==0) {
                Container parent = this.getParent();
                Container grandParent = parent.getParent();
                Container grandGrandParent = grandParent.getParent();
                Container root = grandGrandParent.getParent();
                root.removeAll();
                root.revalidate();
                root.repaint();

                //new screen
                State.SUM = 0;
                State.OPERATION = State.generateOperation(State.ATTEMPTS);
                Components.Buttons = new JButton[State.GAME_WIDTH][State.GAME_HEIGHT];
                Components.NEXT_OPERATION = new NextOperation();
                State.TARGET = Integer.parseInt(Components.TARGET_FIELD.getText());
                State.ATTEMPTS = Integer.parseInt(Components.ATTEMPTS_FIELD.getText());

                Components.TARGET_BUTTON.setText(Integer.toString(State.TARGET));
                Components.ATTEMPTS_BUTTON.setText(Integer.toString(State.ATTEMPTS));
                root.add(Components.MENU_PAGE);
            }
        }

        if(State.LAST_CLICK[0] != -1){
            Components.Buttons[State.LAST_CLICK[0]][State.LAST_CLICK[1]].setEnabled(true);

            //BUG
            int gameOperation = Mod(State.OPERATION.get(0));

            Components.Buttons[State.LAST_CLICK[0]][State.LAST_CLICK[1]].setText(
                    Integer.toString(gameOperation)
            );
            State.SUM = 0;
            //POPRAVITI
            for(int i = 0; i < State.GAME_WIDTH; i++){
                for(int j = 0; j < State.GAME_HEIGHT; j++){
                    State.SUM += Integer.parseInt(Components.Buttons[i][j].getText());
                }
            }
             // treba biti float, mislim da nije dobro da ima decimalni zarez
            Components.SUM_BUTTON.setText(Integer.toString(State.SUM));
        }

        this.setEnabled(false);

        if(State.ATTEMPTS == 1){
            String[] opcije = {"OK"};
            int odabir = JOptionPane.showOptionDialog(null, "Vas skor je:"+Math.abs(State.TARGET-State.SUM), "END", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcije, opcije[0]);
            if (odabir ==0) {
                Container parent = this.getParent();
                Container grandParent = parent.getParent();
                Container grandGrandParent = grandParent.getParent();
                Container root = grandGrandParent.getParent();
                root.removeAll();
                root.revalidate();
                root.repaint();
                //new screen
                State.SUM = 0;
                State.OPERATION = State.generateOperation(State.ATTEMPTS);
                Components.Buttons = new JButton[State.GAME_WIDTH][State.GAME_HEIGHT];
                Components.NEXT_OPERATION = new NextOperation();
                State.TARGET = Integer.parseInt(Components.TARGET_FIELD.getText());
                State.ATTEMPTS = Integer.parseInt(Components.ATTEMPTS_FIELD.getText());

                Components.TARGET_BUTTON.setText(Integer.toString(State.TARGET));
                Components.ATTEMPTS_BUTTON.setText(Integer.toString(State.ATTEMPTS));
                root.add(Components.MENU_PAGE);
            }
        }else {
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.Click();
    }
}
