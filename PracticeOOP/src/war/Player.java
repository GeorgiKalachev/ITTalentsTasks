package war;

public class Player {
    private String name;
    private Card[] cards = new Card[26];
    private Card[] taken = new Card[0];
    
    Player(String name){
        this.name = name;
    }
    
    public int getNextCardIndex(){
        int index = -1;
        for (int i = this.cards.length-1; i >= 0; i--) {
            if (this.cards[i] != null){
                index = i;
                break;
            }
        }
        return index;
    }
    public Card pickCard(int index){
        if(index < 0){
            index = 0;
        }
        Card nextCard = this.cards[index];
        this.cards[index] = null;
        return nextCard;
    }
    public void takeHand(Card[] hand){
        Card[] newTaken = new Card[this.taken.length + hand.length];
        for (int i = 0; i < newTaken.length; i++) {
            if (i < this.taken.length){
                newTaken[i] = this.taken[i];
            }
            else {
                newTaken[i] = hand[i-this.taken.length];
            }
        }
        this.taken = newTaken;
        System.out.print(" " + this.name + "'s hand is ");
        for (int i = 0; i < taken.length; i++) {
            taken[i].printCard();
        }
        System.out.println();
    }

    public void setCardInCards(int ind, Card card) {
        this.cards[ind] = card;
    }

    public Card[] getTaken() {
        return taken;
    }

    public String getName() {
        return name;
    }

    public Card[] getCards() {
        return cards;
    }
}
