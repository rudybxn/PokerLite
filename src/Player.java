import java.util.*;

public abstract class Player {

    ArrayList<Integer> hand =new ArrayList<>();
    ArrayList<Integer> deck=new ArrayList<>();

    public Player(ArrayList<Integer> a,ArrayList<Integer> d){
        this.hand =a;
        this.deck = d;
    }
    public abstract ArrayList<Integer> play()throws Exception;
    public abstract boolean isPair(ArrayList<Integer> hand)throws Exception;
    public ArrayList<Integer> getHand(){
        return this.hand;
    }

    public void setHand(ArrayList<Integer> h){
        this.hand =h;
    }
}
