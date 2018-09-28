import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Player {
    //TODO more protected, less public?
    private List<Domino> dominoes = new ArrayList<>();
    private String name;
    public Player(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setDominoes(List<Domino> dominoes){
        this.dominoes=dominoes;
    }
    protected List<Domino> peekDominoes(){
        return Collections.unmodifiableList(dominoes);
    }
    protected void removeDomino(int index){
        dominoes.remove(index);
    }
    protected List<Domino> getStonesThatFit(Domino gameStone){
        ArrayList<Domino> returnArrayList = new ArrayList<>();
        dominoes.stream()
                .filter(d->d.getLeft()==gameStone.getRight()||d.getRight()==gameStone.getLeft())
                .forEach(d->returnArrayList.add(d));
        return returnArrayList;
    }
    protected Domino selectDomino(List<Domino> selectableDominoes,int index){
        Domino returnDomino=null;
        if(!selectableDominoes.isEmpty()&&index>=0) {
            if(index<selectableDominoes.size()) {
                returnDomino = selectableDominoes.get(index);
                removeDomino(dominoes.indexOf(returnDomino));
            }
        }else {
            System.out.println("Keine Anlegemöglichkeit");
        }
        return returnDomino;
    }
    public boolean isOutOfDominoes(){
        return dominoes.size()<1;
    }
    public String getDominoString(){
        return "[" +peekDominoes().stream().map(d->d.toString()).reduce((s1,s2)->s1+s2).orElse("") + "]";
    }
    public void addDomino(Domino domino){
        dominoes.add(domino);
    }


    public abstract Sides getSideToAddTo(Domino toAdd, Domino gameStone);

    public abstract Domino getNextStone(Domino gameStone);

}
