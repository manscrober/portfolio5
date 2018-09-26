import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.startDomino();
    }
    public void startDomino(){
        HumanPlayer human = new HumanPlayer("Sie");
        ComputerPlayer com = new ComputerPlayer("Ich");
        DominoGame game = new DominoGame(human,com);
        game.start();
    }

}
