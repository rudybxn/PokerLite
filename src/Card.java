public class Card {
    private Rank rank;
    public Card(Rank r){
        this.rank=r;
    }

    public static enum Rank{
        ONE('1'),TWO('2'),THREE('3');
        private char Rankletter;
        Rank(char symbol){
            this.Rankletter = symbol;
        }
        public char getRankletter(){
            return this.Rankletter;
        }
        public void setRankletter(char rl){
            this.Rankletter = rl;
        }
    }

    public char getRankChar(){
        return this.rank.Rankletter;
    }

    public Rank getRankEnum(){
        return this.rank;
    }

    public void setRankEnum(Rank r) {
        this.rank = r; //this.rank.equals(rank)
    }
}
