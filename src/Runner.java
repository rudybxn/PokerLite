import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;


public class Runner {
    static ArrayList<Integer> deck = new ArrayList<>(Arrays.asList(1,1,1,2,2,2,3,3,3));
    private static Random random = new Random();
    static ArrayList<Double> value  = new ArrayList<>(Arrays.asList(0.5,0.5,0.5,0.5,0.5,0.5));
    static double LEARNING_RATE = 0.3;
    static int ITERATIONS = 10;


    public static void main(String [] args)throws Exception {
        System.out.println("What game do you want to play?");
        // System.out.println()
        System.out.println(deck.get(5));
        int iterate = 0;
        while (iterate < ITERATIONS) {
            System.out.println("Game "+iterate);
            ArrayList<Integer> hand1 = drawHand();
            ArrayList<Integer> hand2 = drawHand();
            ArrayList<Integer> playedhand = new ArrayList<Integer>();
            deck =  new ArrayList<>(Arrays.asList(1,1,1,2,2,2,3,3,3)); //replenish
           // System.out.println(hand1); //player hand
           // System.out.println(hand2); //uncomment to see computer hand

            System.out.println("Who do you want the games against?");
            System.out.println("Press corresponding numbers: 1) Randy  2) OddBall  3) Deep Preschooler  4)Yourself");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int x = Integer.parseInt(br.readLine());
            if (x == 1) {
                System.out.println("You have chosen Randy.");
               // Randy randy = new Randy(hand1, deck);
                playedhand = Randyplay(hand1);
                int value1 = handScore(playedhand);
                int value2 = handScore(hand2);
                if (value1 > value2) {
                    System.out.println("Randy wins.");
                } else if (value2 > value1) {
                    System.out.println("Computer wins");
                } else if (value2==value1) {
                    System.out.println("Game tie.");
                }
            }
            if (x == 2) {
                System.out.println("You have chosen OddBall.");
                OddBall odb = new OddBall(hand1, deck);
                playedhand = OddBallplay(hand1);
                int value1 = handScore(playedhand);
                int value2 = handScore(hand2);
                if (value1 > value2) {
                    System.out.println("OddBall wins.");
                }
                else if (value2 > value1) {
                    System.out.println("Computer wins");
                } else if (value2==value1) {
                    System.out.println("Game tie.");
                }

            }
            if (x == 3) {
                System.out.println("You have chosen DeepPreschooler.");
                DeepPreschooler dp = new DeepPreschooler(hand1, deck);
                playedhand = DeepPreeschoolerplay(hand1);
                int value1 = handScore(playedhand);
                int value2 = handScore(hand2);
                if (value1 > value2) {
                    System.out.println("Deep Preschooler wins.");
                } else if (value2 > value1) {
                    System.out.println("Computer wins");
                } else if (value2==value1){
                    System.out.println("Game tie.");
                }
            }
            if (x == 4) {
                System.out.println("You have chosen yourself.");
                playedhand = playDrawOne(hand1);
                int value1 = handScore(playedhand);
                int value2 = handScore(hand2);
                if (value1 > value2) {
                    System.out.println("You win.");
                } else if (value2 > value1) {
                    System.out.println("Computer wins.");
                } else if (value2==value1){
                    System.out.println("Game tie.");
                }
            }
            iterate++;
        }
    }

    public static ArrayList<Integer> drawHand(){
        ArrayList<Integer> l1 = new ArrayList<Integer>();
        int index = 0;
        for(int i=0; i < 2; i++){
            index = random.nextInt(deck.size());
            l1.add(deck.get(index));
            deck.remove(index);
        }
        return l1;
    }

    public static ArrayList<Integer> gameLogic(ArrayList<Integer> value, ArrayList<Integer> deck){
        for(int i =0;i<value.size();i++){
            double present = value.get(i);
            long vnew = Math.round((value.get(i)+LEARNING_RATE*(1-present)));
            value.set(i, Math.round(vnew));
        }
        return value;

    }

    public static ArrayList<Integer> playDrawOne(ArrayList<Integer> hand)throws Exception{
        System.out.println("Your hand is: ");
        System.out.println(hand);
        ArrayList<Integer> newHand =  new ArrayList<Integer>();

        System.out.println("What would you like to do? 1) Discard 1, 2) Discard 2, 3) Discard 3, 4)Stand");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        if(x==1){
            int idx = hand.indexOf(1);
            if(idx==-1){
                System.out.println("Discard 1 not possible.");
            }else{
                newHand = discard1(hand);
                System.out.println("New hand:"+newHand);
            }
        }
        if(x==2){
            int idx = hand.indexOf(2);
            if(idx==-1){
                System.out.println("Discard 2 not possible.");
            }else{
                newHand = discard2(hand);
                System.out.println("New hand:"+newHand);
            }
        }
        if(x==3){
            int idx = hand.indexOf(3);
            if(idx==-1){
                System.out.println("Discard 3 not possible.");
            }else{
                newHand = discard3(hand);
                System.out.println("New hand:"+newHand);
            }
        }
        if(x==4){
            newHand=hand;
        }
        return newHand;
    }


    public static  ArrayList<Integer> discard1(ArrayList<Integer> hand){
        int index = hand.indexOf(1); //find index of 1 deck has 5
        Random random = new Random();
        hand.remove(index); //remove 1 from hand
        deck.add(1); //add 1 to deck
        int choose = random.nextInt((deck.size()));
        //System.out.println(choose);
        hand.add(deck.get(choose)); //pick another card from deck
        deck.remove(deck.get(choose));
        return hand;

    }
    public static ArrayList<Integer> discard2(ArrayList<Integer> hand){
        int index = hand.indexOf(2);
        Random random = new Random();
        hand.remove(index);
        deck.add(2);
        int choose = random.nextInt((deck.size()));
        hand.add(deck.get(choose)); //pick another card from deck
        deck.remove(deck.get(choose));
        return hand;

    }
    public static ArrayList<Integer> discard3(ArrayList<Integer> hand){
        int index = hand.indexOf(3); //index of 3
        Random random = new Random();
        hand.remove(index); //remove 3
        deck.add(3); //add 3 to deck
        int choose = random.nextInt((deck.size())); //choose from deck
        hand.add(deck.get(choose));//add to hand
        deck.remove(deck.get(choose));
        return hand;

    }

    public static int handScore(ArrayList<Integer> hand){
        int a =hand.get(0);int b=hand.get(1);
        System.out.println(a);
        System.out.println(b);
        int score =0;
        if(a==1 && b==1){
            score =100;
        }
        if(a==1 && b==2){
            score =3;
        }
        if(a==1 && b==3){
            score =4;
        }
        if(a==2 && b==1){
            score =3;
        }
        if(a==2 && b==2){
            score =200;
        }
        if(a==2 && b==3){
            score =5;
        }
        if(a==3 && b==1){
            score =4;
        }
        if(a==3 && b==2){
            score =5;
        }
        if(a==3 && b==3){
            score =300;
        }
        return score;

    }

    public static ArrayList<Integer> Randyplay(ArrayList<Integer> hand){
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
            newhand = discard1(hand);
        }
        if(chosenmove.equals("Discard-2")){
            newhand = discard2(hand);
        }
        if(chosenmove.equals("Discard-3")){
            newhand=discard3(hand);
        }
        return newhand;

    }

    public static ArrayList<Integer> DeepPreeschoolerplay(ArrayList<Integer> hand)throws Exception{
        ArrayList<String> choices = new ArrayList<String>();
        ArrayList<Integer> newhand = new ArrayList<>();


        if (isPair(hand)){
            System.out.println("Deep chooses to stand");
            return hand;
        }else {
            if (hand.contains(1)) {
                newhand = discard1(hand);
            }
        }
        return newhand;

    }

    public static ArrayList<Integer> OddBallplay(ArrayList<Integer> hand){
        ArrayList<String> choices = new ArrayList<String>();
        ArrayList<Integer> newhand = new ArrayList<>();

        int a = hand.get(0);int b =hand.get(1);
        int m=Math.min(a,b);
        if(m==1){
            newhand=discard1(hand);
        }
        if(m==2){
            newhand=discard2(hand);
        }
        if(m==3){
            newhand=discard3(hand);
        }
        return newhand;

    }

    public static boolean isPair(ArrayList<Integer> hand)throws Exception{
        int a = hand.get(0);int b =hand.get(1);
        return a==b;
    }





}
