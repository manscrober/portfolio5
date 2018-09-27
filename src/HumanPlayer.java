import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HumanPlayer extends Player {
    public HumanPlayer(String name){
        super(name);
    }

    public Domino getNextStone(Domino gameStone){
        if(!getStonesThatFit(gameStone).isEmpty()) {
            UserDialog dialog = new UserDialog();
            List<Domino> selectableDominoes = getStonesThatFit(gameStone);
            String[] selectableDominoStrings = selectableDominoes.stream().map(d -> d.toString()).toArray(String[]::new);

            System.out.println("Ihre Steine: " + getDominoString());
            int choice = dialog.getUserInput("Auswahlmöglichkeiten", selectableDominoStrings);
            Domino returnDomino = selectableDominoes.get(choice);
            removeDomino(choice);
            return returnDomino;
        }else{
            return null;
        }
    }

    public Sides getSideToAddTo(Domino toAdd, Domino gameStone){
        List<Sides> possibleSides = new ArrayList<>();
        if (toAdd.getLeft() == gameStone.getRight()) {
            possibleSides.add(Sides.right);
        }
        if (toAdd.getRight() == gameStone.getLeft()) {
            possibleSides.add(Sides.left);
        }
        UserDialog dialog = new UserDialog();
        String[] possibleSideStrings = possibleSides.stream().map(s->s.toString()).toArray(String[]::new);
        Sides returnSide;
        if(possibleSides.size()>1) {
            returnSide = possibleSides.get(
                    dialog.getUserInput("Wo soll der stein angelegt werden?", possibleSideStrings));
        }else{
            returnSide=possibleSides.get(0);
        }
        return returnSide;
    }

}