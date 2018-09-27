public enum Sides {
    left,right;
    public String toString(){
        if(this==Sides.left){
            return "Links anlegen";
        }else{
            return "Rechts anlegen";
        }
    }
}
