import java.util.List;

public class ComputerPlayer extends Player {
    public ComputerPlayer(String name){
        super(name);
    }
    public Domino getNextStone(){
        Domino returnDomino = peekDominoes().get(0);
        removeDomino(0);
        System.out.println(super.getName() + ": " + returnDomino);
        return returnDomino;
    }
}