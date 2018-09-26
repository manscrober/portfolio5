import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HazardingPlayer extends Player {

    public HazardingPlayer(String name){
        super(name);
    }
    public Domino getNextStone() {
        if(peekDominoes()!=null) {
            Random rand = new Random();
            rand.setSeed(System.nanoTime());
            int indexOfReturnDomino = rand.nextInt(peekDominoes().size());
            Domino returnDomino=peekDominoes().get(indexOfReturnDomino);
            removeDomino(indexOfReturnDomino);
            return returnDomino;
        }else{
            return null;
        }
    }
}
