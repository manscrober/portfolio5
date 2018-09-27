import java.util.ArrayList;
import java.util.List;

public class ComputerPlayer extends Player {
    public ComputerPlayer(String name){
        super(name);
    }
    public Domino getNextStone(Domino gameStone){
        if(!getStonesThatFit(gameStone).isEmpty()) {
            Domino returnDomino = getStonesThatFit(gameStone).get(0);
            System.out.println(super.getName() + ": " + returnDomino);
            removeDomino(peekDominoes().indexOf(returnDomino));
            return returnDomino;
        }else{
            return null;
        }
    }
    public Sides getSideToAddTo(Domino toAdd,Domino gameStone){
        List<Sides> possibleSides = new ArrayList<>();
        if (toAdd.getLeft() == gameStone.getRight()) {
            possibleSides.add(Sides.right);
        }
        if (toAdd.getRight() == gameStone.getLeft()) {
            possibleSides.add(Sides.left);
        }
        if(possibleSides.size()>1) {
            System.out.println(getName() + ": " + possibleSides.get(0));
        }
        return possibleSides.get(0);
    }
}