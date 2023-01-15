package state;


import game.Game;
import game.components.apttempts.Attempts;
import game.components.next_operation.NextOperation;
import game.components.save_and_back.SaveAndBack;
import game.components.sum.Sum;
import game.components.target.Target;
import game.main_game.buttons.MainButton;
import menu.Menu;
import menu.button.Exit;
import menu.button.Load;
import menu.button.Settings;
import menu.button.Start;

import javax.swing.*;

public class Components {

    // public static JButton MyButton = new Button(State.text);
    public static JTextField ATTEMPTS_FIELD = new JTextField(8);
    public static JTextField ROW_FIELD = new JTextField(8);
    public static  JTextField COLUMN_FIELD = new JTextField(8);
    public static JTextField TARGET_FIELD = new JTextField(8);
    public static JButton PLAY_BUTTON = new Start("START");
    public static JButton SETTINGS_BUTTON = new Settings("SETTINGS");
    public static JButton LOAD_BUTTON = new Load("LOAD");
    public static JButton EXIT_BUTTON = new Exit("EXIT");
    public static JButton SUM_BUTTON  = new Sum(State.SUM);
    public static JButton ATTEMPTS_BUTTON = new Attempts(State.ATTEMPTS);
    public static  JButton QUIT_BUTTON = new SaveAndBack();
    public static JPanel NEXT_OPERATION = new NextOperation();
    public static JButton TARGET_BUTTON = new Target(State.TARGET);
    public static JButton Buttons[][] = new MainButton[State.GAME_WIDTH][State.GAME_HEIGHT];
    public static JPanel MENU_PAGE = new Menu();
    public static JPanel GAME_PAGE = new Game();
    public static JPanel SETTINGS_PAGE = new settings.Settings();
}
