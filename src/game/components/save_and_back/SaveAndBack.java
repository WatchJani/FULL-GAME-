package game.components.save_and_back;

import game.components.next_operation.NextOperation;
import state.Components;
import state.State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveAndBack extends JButton implements ActionListener {
    public SaveAndBack(){
        super("QUIT");
        this.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int odgovor = JOptionPane.showOptionDialog(null, "Zelite li sacuvati ovaj napredak?", "Potvrda", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (odgovor == JOptionPane.YES_OPTION) {

            String gameSet = "";

            for(int i=0; i< Components.Buttons.length; i++){
                for(int k = 0; k < Components.Buttons[i].length; k++){
                    gameSet+=Components.Buttons[i][k].getText();
                }
                    gameSet+="\n";
            }

            String SuperOperation = "";
            for (int i = 0; i < State.OPERATION.size();i++){
                SuperOperation+=State.OPERATION.get(i);
            }

            String[] data = {""+State.GAME_WIDTH,""+State.GAME_HEIGHT,""+State.TARGET, ""+State.ATTEMPTS, SuperOperation, gameSet};
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Save File");
            chooser.setApproveButtonText("Save");
            int userSelection = chooser.showSaveDialog(null);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = chooser.getSelectedFile();
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave));
                    for (String s : data) {
                        writer.write(s);
                        writer.newLine();
                    }
                    writer.close();
                    JOptionPane.showMessageDialog(null, "Fajl sacuvan!");

                    Container parent = this.getParent();
                    Container grandParent = parent.getParent();
                    Container grandGrandParent = grandParent.getParent();
                    grandGrandParent.removeAll();
                    grandGrandParent.revalidate();
                    grandGrandParent.repaint();

                    grandGrandParent.add(Components.MENU_PAGE);
                } catch (IOException er) {
                    er.printStackTrace();
                }
            }
        } else {
            State.SUM = 0;
            State.OPERATION = State.generateOperation(State.ATTEMPTS);
            Components.Buttons = new JButton[State.GAME_WIDTH][State.GAME_HEIGHT];
            Components.NEXT_OPERATION = new NextOperation();
            State.TARGET = Integer.parseInt(Components.TARGET_FIELD.getText());
            State.ATTEMPTS = Integer.parseInt(Components.ATTEMPTS_FIELD.getText());

            Components.TARGET_BUTTON.setText(Integer.toString(State.TARGET));
            Components.ATTEMPTS_BUTTON.setText(Integer.toString(State.ATTEMPTS));

            Container parent = this.getParent();
            Container grandParent = parent.getParent();
            Container grandGrandParent = grandParent.getParent();
            grandGrandParent.removeAll();
            grandGrandParent.revalidate();
            grandGrandParent.repaint();

            grandGrandParent.add(Components.MENU_PAGE);
        }
    }
}