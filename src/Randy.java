import java.lang.reflect.Array;
import java.util.*;

public class Randy extends Player{
    ArrayList<Integer> hand=new ArrayList<>();
    ArrayList<Integer> deck=new ArrayList<>();

    public Randy(ArrayList<Integer> h, ArrayList<Integer> d){
        super(h,d);
    }

    public ArrayList<Integer> play(){
        ArrayList<String> choices = new ArrayList<String>();
        ArrayList<Integer> newhand = new ArrayList<>();

        choices.add("Stand");
        if(hand.contains(1)){
            choices.add("Discard-1");
        }
        if(hand.contains(2)){
            choices.add("Discard-2");
        }
        if(hand.contains(3)){
            choices.add("Discard-3");
        }
        Random random = new Random();
        int index = random.nextInt(choices.size());
        String chosenmove = choices.get(index);
        if(chosenmove.equals("Stand")) {
            System.out.println("Randy chooses to stand");
            newhand=hand;
        }
        if(chosenmove.equals("Discard-1")){
           newhand = discard1();
        }
        if(chosenmove.equals("Discard-2")){
            newhand = discard2();
        }
        if(chosenmove.equals("Discard-3")){
            newhand=discard3();
        }
        return newhand;

    }

    public boolean isPair(ArrayList<Integer> a){
        return true;
    }

    public ArrayList<Integer> discard1(){
        int index = this.hand.indexOf(1); //find index of 1 deck has 5
        Random random = new Random();
        hand.remove(index); //remove 1 from hand
        deck.add(1); //add 1 to deck
        int choose = random.nextInt((deck.size()));
        hand.add(choose); //pick another card from deck
        deck.remove(deck.indexOf(choose));
        return hand;

    }
    public ArrayList<Integer> discard2(){
        int index = this.hand.indexOf(2); //find index of 1 deck has 5
        Random random = new Random();
        hand.remove(index); //remove 1 from hand
        deck.add(2); //add 1 to deck
        int choose = random.nextInt((deck.size()));
        hand.add(choose); //pick another card from deck
        deck.remove(deck.indexOf(choose));
        return hand;

    }
    public ArrayList<Integer> discard3(){
        int index = this.hand.indexOf(3); //find index of 1 deck has 5
        Random random = new Random();
        hand.remove(index); //remove 1 from hand
        deck.add(3); //add 1 to deck
        int choose = random.nextInt((deck.size()));
        hand.add(choose); //pick another card from deck
        deck.remove(deck.indexOf(choose));
        return hand;

    }
}
