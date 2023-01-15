package state;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class State {

    public static List<String> generateOperation(int Attempts){
        Random rand = new Random();
        String[] singleOperation = {"+", "-", "*", "/"};

        ArrayList<String> Operation = new ArrayList<>();
        Operation.add("+");

        for (int i = 1; i<Attempts;i++){
            Operation.add(singleOperation[rand.nextInt(singleOperation.length)]);
        }

        return Operation;
    }
    public static int GAME_HEIGHT = 15;
    public static int GAME_WIDTH = 15;
    public static int  TARGET = GAME_HEIGHT * GAME_WIDTH * 9 / 2;
    public static int ATTEMPTS = 20;
    public static int SUM = 0;
    public static List<String> OPERATION = generateOperation(ATTEMPTS);
    public static int[] LAST_CLICK = {-1,-1};
}
