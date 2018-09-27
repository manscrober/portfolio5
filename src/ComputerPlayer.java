import java.util.ArrayList;
import java.util.List;

public class ComputerPlayer extends Player {
    public ComputerPlayer(String name){
        super(name);
    }
    public Domino getNextStone(Domino gameStone) {
        List<Domino> selectableDominoes = getStonesThatFit(gameStone);
        int randomChoice = getChoice(selectableDominoes.size());
        Domino returnDomino = selectDomino(selectableDominoes,randomChoice);
        if(returnDomino!=null) {
            System.out.println(getName() + ": " + returnDomino);
        }
        return returnDomino;
    }
    public Sides getSideToAddTo(Domino toAdd,Domino gameStone){
        List<Sides> possibleSides = new ArrayList<>();
        if (toAdd.getLeft() == gameStone.getRight()) {
            possibleSides.add(Sides.right);
        }
        if (toAdd.getRight() == gameStone.getLeft()) {
            possibleSides.add(Sides.left);
        }

        int randomChoice = getChoice(possibleSides.size());
        Sides returnSide= possibleSides.get(randomChoice);
        if(possibleSides.size()>1) {
            System.out.println(getName() + ": " + possibleSides.get(randomChoice));
        }
        return returnSide;
    }

    protected int getChoice(int boundary){
        return 0;
    }
}