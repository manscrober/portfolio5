import java.util.ArrayList;
import java.util.List;

public class Test {
    @org.junit.Test
    public void TestDominoHeapNullReturn(){
        List<Domino> dominoList=new ArrayList<>();
        dominoList.add(new Domino(2,4));
        dominoList.add(new Domino(3,1));
        DominoHeap dh=new DominoHeap(dominoList);
        ComputerPlayer com = new ComputerPlayer("ich");
        com.addDomino(dh.pickDominoes(1).get(0));
        com.addDomino(dh.pickDominoes(1).get(0));
        assert(dh.pickDominoes(1)==null);
        assert(dh.getSize()==0);
    }
    @org.junit.Test
    public void testComVsCom(){
        ComputerPlayer h1 =new ComputerPlayer("COM1");
        ComputerPlayer h2 = new ComputerPlayer("COM2");
        DominoGame dg = new DominoGame(h1,h2);
        dg.start();
    }
    @org.junit.Test
    public void testHazVsHaz(){
        HazardingPlayer h1 =new HazardingPlayer("COM1");
        HazardingPlayer h2 = new HazardingPlayer("COM2");
        DominoGame dg = new DominoGame(h1,h2);
        dg.start();
    }
    @org.junit.Test
    public void testMaxPlayerCountCheck(){
        ComputerPlayer[] players = new ComputerPlayer[5];
        for(int i=0;i<players.length;i++){
            players[i]=new ComputerPlayer("mark");
        }
        DominoGame dg = new DominoGame(players);
        dg.start();
    }
    @org.junit.Test
    public void testGameWithMaxPlayerCount(){
        ComputerPlayer[] players = new ComputerPlayer[4];
        for(int i=0;i<players.length;i++){
            players[i]=new ComputerPlayer("mark" + i);
        }
        DominoGame dg = new DominoGame(players);
        dg.start();
    }

}
