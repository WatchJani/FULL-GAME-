package menu.button;

import game.Game;
import game.components.next_operation.NextOperation;
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
            System.out.println(file.getAbsolutePath());

            BufferedReader reader = null;
            try {

                reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
                reader.close();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            System.out.println(lines);


            System.out.println(lines.get(0));

            State.SUM = 0;
            State.GAME_HEIGHT = Integer.parseInt(lines.get(0));
            State.GAME_WIDTH = Integer.parseInt(lines.get(1));
            State.TARGET =Integer.parseInt(lines.get(2));
            State.ATTEMPTS =Integer.parseInt(lines.get(3));

            Components.TARGET_BUTTON.setText(Integer.toString(State.TARGET));
            Components.ATTEMPTS_BUTTON.setText(Integer.toString(State.ATTEMPTS));

            State.OPERATION = State.generateOperation(State.ATTEMPTS);

            Components.Buttons = new JButton[State.GAME_WIDTH][State.GAME_HEIGHT];

            Components.NEXT_OPERATION = new NextOperation();
            Components.GAME_PAGE = new Game();

            Container parent = this.getParent();
            Container grandParent = parent.getParent();
            Container grandGrandParent = grandParent.getParent();
            grandGrandParent.removeAll();
            grandGrandParent.revalidate();
            grandGrandParent.repaint();

            grandGrandParent.add(Components.GAME_PAGE);
        }
    }
}