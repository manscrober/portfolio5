
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DominoGame {
    private static final int NUMBER_OF_STONES_PER_PLAYER = 5;
    private Domino gameStone;
    private Player[] players;
    private int[] playerScores;
    private DominoHeap dominoHeap;
    private DominoPool dominoPool;
    private int playersStalling=0;
    public DominoGame(Player... players){
        this.players=players;
        playerScores=new int[players.length];

        dominoPool = new DominoPool();
    }
    public void start(){
        dominoHeap = new DominoHeap(dominoPool.provideShuffledDominoHeap());
        if(dominoHeap.getSize()>NUMBER_OF_STONES_PER_PLAYER*players.length) {
            playMatch();
        }
    }

    private void playMatch() {
        Stream.of(players).forEach(p -> p.setDominoes(dominoHeap.pickDominoes(NUMBER_OF_STONES_PER_PLAYER)));
        gameStone = dominoHeap.pickDominoes(1).get(0);

        boolean someoneWon=false;
        while (playersStalling <= players.length && !someoneWon) {
            someoneWon = playRound();
        }
        calculatePlayerScores();
        finishGame();
    }

    private boolean playRound() {
        boolean someoneWon=false;
        for(int i=0;i<players.length&&!someoneWon;i++) {
            if (!players[i].isOutOfDominoes()) {
                playMove(players[i]);
            }
            if (players[i].isOutOfDominoes()) {

                someoneWon=true;
            }
        }
        return someoneWon;
    }


    private void playMove(Player player){
        System.out.println("Anlegemöglickeit:"+gameStone);
        Domino addedDomino = player.getNextStone(gameStone);
        if(addedDomino==null){
            if(dominoHeap.getSize()>0) {
                player.addDomino(dominoHeap.pickDominoes(1).get(0));
            }else{
                playersStalling++;
            }
        }else {
            playersStalling--;
            Sides sideToAddTo = player.getSideToAddTo(addedDomino,gameStone);
            if (sideToAddTo==Sides.right) {
                gameStone.setRight(addedDomino.getRight());
            } else if (sideToAddTo==Sides.left) {
                gameStone.setLeft(addedDomino.getLeft());
            }
        }
    }
    private void calculatePlayerScores(){
        for(int i=0;i<players.length;i++){
            playerScores[i]+=players[i].peekDominoes().stream()
                                        .map(d->d.getLeft()+d.getRight())
                                        .reduce((d1,d2)->d1+d2)
                                        .orElse(0);
        }
    }
    private void finishGame(){
        UserDialog userDialog = new UserDialog();
        System.out.println("Spielende");
        Stream.of(players).forEach(p->System.out.println(p.getName()+": "+p.getDominoString()));
        String playerNames = Stream.of(players)
                                    .map(p->p.getName())
                                    .reduce((s1,s2)->s1 +"-" +s2)
                                    .orElse("");

        String playerScoresString = Arrays.stream(playerScores)
                                            .mapToObj(i->Integer.toString(i))
                                            .reduce((s1,s2)->s1+":"+s2).orElse("");
        System.out.println(playerNames+ " "+ playerScoresString);
        int anotherRound =  userDialog.getUserInput("Weitere Runde?", "Nein","Ja");
        if(anotherRound==1){
            start();
        }else{
            System.out.println("Tschüß");
        }
    }
}
