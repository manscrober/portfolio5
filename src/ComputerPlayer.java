public class ComputerPlayer extends Player {
    public ComputerPlayer(ComputerPlayer p){
        super(p);
    }
    public Domino getNextStone(){
        return getDominoes().get(0);
    }
    public ComputerPlayer copy(){return new ComputerPlayer(this);}
}