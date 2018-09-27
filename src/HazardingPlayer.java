import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HazardingPlayer extends ComputerPlayer {

    public HazardingPlayer(String name){
        super(name);
    }

    protected int getChoice(int boundary){
        Random rand = new Random();
        rand.setSeed(System.nanoTime());
        int choice = 0;
        if(boundary>1){
            rand.nextInt(boundary);
        }
        return choice;
    }
}
