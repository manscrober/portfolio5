
public class HumanPlayer extends Player {


    public Domino getNextStone(){
        UserDialog dialog = new UserDialog();
        String[] dominoStrings = getDominoes().stream().map(d->d.toString()).toArray(String[]::new);

        int choice = dialog.getUserInput("Auswahlmöglichkeiten",dominoStrings);
        return getDominoes().get(choice);
    }

}