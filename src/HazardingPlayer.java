import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HazardingPlayer extends Player {

    public HazardingPlayer(String name){
        super(name);
    }
    public Domino getNextStone(Domino gameStone) {
        List<Domino> selectableDominoes = getStonesThatFit(gameStone);
        if(!selectableDominoes.isEmpty()) {
            Random rand = new Random();
            rand.setSeed(System.nanoTime());
            Domino returnDomino = selectableDominoes.get(rand.nextInt(selectableDominoes.size()));
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
        Random rand = new Random();
        rand.setSeed(System.nanoTime());
        return possibleSides.get(rand.nextInt(possibleSides.size()));
    }
}
