import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Player {
    private List<Domino> dominoes = new ArrayList<>();
    public Player(Player p){
        this.dominoes=p.dominoes;//TODO why exactly are we doing it this way? why not just copy dominoes to a new player
                                //or even instantiate using the dominoes?
    }
    public void setDominoes(List<Domino> dominoes){
        this.dominoes=dominoes;
    }
    public List<Domino> getDominoes(){
        return this.dominoes;
    }
    public void addDomino(Domino domino){
        dominoes.add(domino);
    }
    public abstract Domino getNextStone();
    public abstract Player copy();
}
