import java.util.ArrayList;
import java.util.Random;

public class OddBall extends Player {
    ArrayList<Integer> hand=new ArrayList<>();
    ArrayList<Integer> deck=new ArrayList<>();

    public OddBall(ArrayList<Integer> h, ArrayList<Integer> d){
        super(h,d);
    }

    public ArrayList<Integer> play(){
        ArrayList<String> choices = new ArrayList<String>();
        ArrayList<Integer> newhand = new ArrayList<>();

        int a = hand.get(0);int b =hand.get(1);
        int m=Math.min(a,b);
        if(m==1){
            newhand=discard1();
        }
        if(m==2){
            newhand=discard2();
        }
        if(m==3){
            newhand=discard3();
        }
        return newhand;

    }

    public boolean isPair(ArrayList<Integer> arr){
        return true;
    }

    public ArrayList<Integer> discard1(){
        int index = this.hand.indexOf(1);
        Random random = new Random();
        hand.remove(index);
        deck.add(1);
        hand.add(random.nextInt(deck.size())); //pick another card from deck
        return hand;

    }
    public ArrayList<Integer> discard2(){
        int index = this.hand.indexOf(2);
        Random random = new Random();
        hand.remove(index);
        deck.add(2);
        hand.add(random.nextInt(deck.size())); //pick another card from deck
        return hand;

    }
    public ArrayList<Integer> discard3(){
        int index = this.hand.indexOf(3);
        Random random = new Random();
        hand.remove(index);
        deck.add(3);
        hand.add(random.nextInt(deck.size())); //pick another card from deck
        return hand;

    }
}
