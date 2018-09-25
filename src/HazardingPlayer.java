import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HazardingPlayer extends Player {

    public HazardingPlayer(HazardingPlayer p){
        super(p);
    }
    public Domino getNextStone() {
        List<Domino> dominoes=getDominoes();
        if(dominoes!=null) {
            Random rand = new Random();
            rand.setSeed(System.nanoTime());
            return dominoes.get(rand.nextInt(dominoes.size()));
        }else{
            return null;
        }
    }

    public HazardingPlayer copy(){return new HazardingPlayer(this);}
}
