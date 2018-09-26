import java.util.Collections;
import java.util.List;

public class HumanPlayer extends Player {
    public HumanPlayer(String name){
        super(name);
    }

    public Domino getNextStone(){
        UserDialog dialog = new UserDialog();

        String[] dominoStrings = peekDominoes().stream().map(d->d.toString()).toArray(String[]::new);

        System.out.println("Ihre Steine: " + getDominoString());
        int choice = dialog.getUserInput("Auswahlmöglichkeiten",dominoStrings);
        Domino returnDomino = peekDominoes().get(choice);
        removeDomino(choice);
        return returnDomino;
    }

}