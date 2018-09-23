import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Player {
    private List<Domino> dominoes;
    public void setDominoes(List<Domino> dominoes){
        this.dominoes=dominoes;
    }
    public List<Domino> getDominoes(){
        return Collections.unmodifiableList(dominoes);
    }
    public void addDomino(Domino domino){
        dominoes.add(domino);
    }
    public abstract Domino getNextStone();
}
