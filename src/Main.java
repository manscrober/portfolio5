import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.startDomino();
    }
    public void startDomino(){
        DominoGame game = new DominoGame();
        DominoPool dominoPool = new DominoPool();
        HumanPlayer human = new HumanPlayer();
        ComputerPlayer com = new ComputerPlayer();
        List<Domino> dominoHeap = dominoPool.provideShuffledDominoHeap();
        human.setDominoes(dominoHeap.subList(0,4));
        System.out.println(human.getNextStone());//watch out for nullpointerExcept
    }
}
