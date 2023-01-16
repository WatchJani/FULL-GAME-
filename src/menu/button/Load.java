package menu.button;

import game.Game;
import game.LoadGamePage;
import game.components.next_operation.NextOperation;
import game.main_game.buttons.MainButton;
import state.Components;
import state.State;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class Load extends JButton implements ActionListener {
    public Load(String text){
        super(text);
        this.addActionListener(this);
        CreateButton();
    }

    public void CreateButton(){
        this.setPreferredSize(new Dimension(250, 70));
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<String> lines = new ArrayList<>();
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("text fajli", "txt");
        chooser.setFileFilter(filter);

        int res = chooser.showOpenDialog(null);
        if(res == JFileChooser.APPROVE_OPTION){
            File file = chooser.getSelectedFile();

            ArrayList<String> StateGame = new ArrayList<String>();

            BufferedReader reader = null;
            try {
                int currentLine = 0;
                reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    if (currentLine > 5) {
                            StateGame.add(lines.get(currentLine-1));
                    }
                    lines.add(line);
                    currentLine++;
                }
                reader.close();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }


            State.SUM = 0;
            State.GAME_HEIGHT = Integer.parseInt(lines.get(0));
            State.GAME_WIDTH = Integer.parseInt(lines.get(1));
            State.TARGET =Integer.parseInt(lines.get(2));
            State.ATTEMPTS =Integer.parseInt(lines.get(3));


            Components.TARGET_BUTTON.setText(Integer.toString(State.TARGET));
            Components.ATTEMPTS_BUTTON.setText(Integer.toString(State.ATTEMPTS));

            State.OPERATION.clear();

            for (int i =0; i<State.ATTEMPTS; i++){
                State.OPERATION.add(""+ lines.get(4).charAt(i));
            }

            Components.Buttons = new MainButton[State.GAME_WIDTH][State.GAME_HEIGHT];

            for(int i = 0; i < StateGame.size(); i++){
                for (int j = 0; j < StateGame.get(i).length(); j++){
                    Components.Buttons[i][j] = new MainButton( StateGame.get(i).charAt(j) - '0', i, j);
                }
            }

            Container parent = this.getParent();
            Container grandParent = parent.getParent();
            Container grandGrandParent = grandParent.getParent();
            grandGrandParent.removeAll();
            grandGrandParent.revalidate();
            grandGrandParent.repaint();

            grandGrandParent.add(new LoadGamePage());
        }
    }
}