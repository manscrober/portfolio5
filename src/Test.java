import org.junit.runner.Computer;

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
        HazardingPlayer h1 =new HazardingPlayer("haz1");
        HazardingPlayer h2 = new HazardingPlayer("haz2");
        DominoGame dg = new DominoGame(h1,h2);
        dg.start();
    }
}
