import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HumanPlayer extends Player {
    public HumanPlayer(String name){
        super(name);
    }

    public Domino getNextStone(Domino gameStone){
        List<Domino> selectableDominoes = getStonesThatFit(gameStone);
        int userChoice=getUserChoice(selectableDominoes);

        Domino returnDomino = selectDomino(selectableDominoes,userChoice);
        return  returnDomino;
    }

    private int getUserChoice(List<Domino> selectableDominoes){
        int choice;
        if(selectableDominoes.size()>0) {
            UserDialog dialog = new UserDialog();
            List<String> selectableDominoStrings = selectableDominoes.stream()
                    .map(d -> d.toString())
                    .collect(Collectors.toList());
            selectableDominoStrings.add("ziehen");
            String[] selectableDominoArray = selectableDominoStrings.toArray(new String[selectableDominoStrings.size()]);

            System.out.println("Ihre Steine: " + getDominoString());
             choice = dialog.getUserInput("Auswahlmöglichkeiten: ", selectableDominoArray);
        }else{
            choice=0;
        }
        return choice;
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