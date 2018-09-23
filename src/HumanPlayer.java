import java.util.Collections;
import java.util.List;

public class HumanPlayer extends Player {


    public HumanPlayer(Player p){
        super(p);
    }
    public Domino getNextStone(){
        UserDialog dialog = new UserDialog();

        String[] dominoStrings = getDominoes().stream().map(d->d.toString()).toArray(String[]::new);

        int choice = dialog.getUserInput("Auswahlmöglichkeiten",dominoStrings);
        return getDominoes().get(choice);
    }

    public Player copy(){
        return new HumanPlayer(this);
    }
}