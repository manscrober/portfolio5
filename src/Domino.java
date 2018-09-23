public class Domino {
    private int left;
    private int right;
    public Domino(int left, int right){
        this.left=left;
        this.right=right;
    }
    public int getLeft(){
        return left;
    }
    public int getRight(){
        return right;
    }
    public void setLeft(int left){
        if(left>=0&&left<5) {
            this.left = left;
        }
    }
    public void setRight(int right){
        if(left>=0&&left<5) {
            this.right = right;
        }
    }
    public String toString(){
        String string = "[" + left+"|"+right+"]";
        return string;
    }
}
