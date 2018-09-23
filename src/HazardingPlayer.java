import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HazardingPlayer extends Player {

    public Domino getNextStone() {
        List<Domino> dominoes=getDominoes();
        Random rand = new Random();
        rand.setSeed(System.nanoTime());
        return dominoes.get(rand.nextInt(dominoes.size()));
    }

}
