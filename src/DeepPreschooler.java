import java.util.ArrayList;
import java.util.Random;

public class DeepPreschooler extends Player {
    ArrayList<Integer> hand=new ArrayList<>();
    ArrayList<Integer> deck=new ArrayList<>();

    public DeepPreschooler(ArrayList<Integer> h, ArrayList<Integer> d){
        super(h,d);
    }

    public ArrayList<Integer> play()throws Exception{
        ArrayList<String> choices = new ArrayList<String>();
        ArrayList<Integer> newhand = new ArrayList<>();

       /* choices.add("Stand");
        if(hand.contains(1)){
            choices.add("Discard-1");
        }
        if(hand.contains(2)){
            choices.add("Discard-2");
        }
        if(hand.contains(3)){
            choices.add("Discard-3");
        }*/

        if (isPair(hand)){
            System.out.println("Deep chooses to stand");
            return hand;
        }else {
            if (hand.contains(1)) {
                newhand = discard1();
            }
        }
        return newhand;

    }

    public boolean isPair(ArrayList<Integer> hand)throws Exception{
        int a = hand.get(0);int b =hand.get(1);
        return a==b;
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
