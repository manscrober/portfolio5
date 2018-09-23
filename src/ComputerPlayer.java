public class ComputerPlayer extends Player {
    public ComputerPlayer(){

    }
    public Domino getNextStone(){
        return getDominoes().get(0);
    }
}