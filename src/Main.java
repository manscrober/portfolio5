import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.startDomino();
    }
    public void startDomino(){
        HumanPlayer human = new HumanPlayer();
        ComputerPlayer com = new ComputerPlayer();
        DominoGame game = new DominoGame(human,com);
        game.start();
        System.out.println(human.getNextStone());
    }

}
