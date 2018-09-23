import java.util.ArrayList;
import java.util.List;

public class DominoGame {
    Player player1,player2;
    List<Domino> dominoHeap;
    public DominoGame(Player player1, Player player2){
        this.player1=player1;
        this.player2=player2;
        dominoHeap = new ArrayList<Domino>();
    }
    public void start(){

        DominoPool dominoPool = new DominoPool();
        dominoHeap = dominoPool.provideShuffledDominoHeap();


        player1.setDominoes(dominoHeap.subList(0,5));
        player2.setDominoes(dominoHeap.subList(5,10));
        System.out.println(player1.getNextStone());
        System.out.println(player1.getDominoes());
    }
}
