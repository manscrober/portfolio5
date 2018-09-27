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
        if (toAdd.getLeft() == gameStone.getRight()) {
            return Sides.right;
        } else {
            return Sides.left;
        }
    }
}