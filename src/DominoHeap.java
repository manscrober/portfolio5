import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DominoHeap {
    private List<Domino> dominoes;
    public DominoHeap(List<Domino> dominoes){
        this.dominoes=dominoes;
    }
    public List<Domino> pickDominoes(int numberOfDominoes){
        if(numberOfDominoes<=dominoes.size()) {
            List<Domino> dominoesToReturn = new ArrayList<>(dominoes.subList(0, numberOfDominoes));
            dominoes.removeAll(dominoesToReturn);
            return dominoesToReturn;
        }else{
            return null;
        }
    }

    public int getSize(){
        return dominoes.size();
    }


}
