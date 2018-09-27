import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DominoGame {
    public static final int NUMBER_OF_STONES_PER_PLAYER = 5;
    Domino gameStone;
    Player player1,player2;
    int player1Score,player2Score;
    DominoHeap dominoHeap;
    DominoPool dominoPool;
    int playersStalling=0;
    public DominoGame(Player player1, Player player2){
        this.player1=player1;
        this.player2=player2;
        dominoPool = new DominoPool();
    }
    public void start(){
        dominoHeap = new DominoHeap(dominoPool.provideShuffledDominoHeap());
        if(dominoHeap.getSize()>NUMBER_OF_STONES_PER_PLAYER) {
            player1.setDominoes(dominoHeap.pickDominoes(NUMBER_OF_STONES_PER_PLAYER));
            player2.setDominoes(dominoHeap.pickDominoes(NUMBER_OF_STONES_PER_PLAYER));
            gameStone = dominoHeap.pickDominoes(1).get(0);
        }
        while(playersStalling<=2&&!player1.isOutOfDominoes()&&!player2.isOutOfDominoes()){
            if(!player1.isOutOfDominoes()) {
                playRound(player1);
            }
            if(player1.isOutOfDominoes()){
                player1Score++;
                finishGame();
            }else if(!player2.isOutOfDominoes()) {
                playRound(player2);
            }
            if(player2.isOutOfDominoes()){
                player2Score++;
                finishGame();
            }
        }
    }


    private void playRound(Player player){
        System.out.println("Anlegemöglickeit:"+gameStone);
        Domino addedDomino = player.getNextStone(gameStone);
        if(addedDomino==null){
            if(dominoHeap.getSize()>0) {
                System.out.println("Keine Anlegemöglichkeit");
                player.addDomino(dominoHeap.pickDominoes(1).get(0));
            }else{
                playersStalling++;
            }
        }else {
            Sides sideToAddTo = player.getSideToAddTo(addedDomino,gameStone);
            if (sideToAddTo==Sides.right) {
                gameStone.setRight(addedDomino.getRight());
            } else if (sideToAddTo==Sides.left) {
                gameStone.setLeft(addedDomino.getLeft());
            }
        }
    }
    private void finishGame(){
        UserDialog userDialog = new UserDialog();
        System.out.println("Spielende");
        System.out.println(player1.getName() + ": " + player1.getDominoString());
        System.out.println(player2.getName() + ": " + player2.getDominoString());
        System.out.println(player1.getName() + "-" + player2.getName()+ " "+ player1Score+":"+player2Score);
        int anotherRound =  userDialog.getUserInput("Weitere Runde?", "Nein","Ja");
        if(anotherRound==1){
            start();
        }
    }
}
