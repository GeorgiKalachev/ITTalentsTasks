package war;

public class Hand {
    private Card[] hand;
    
    public Hand(Card[] cards){
        this.hand = new Card[cards.length];
        for (int i = 0; i < cards.length; i++) {
            this.hand[i] = cards[i];
        }
    }
    public Hand(int cardsLenght){
        this.hand = new Card[cardsLenght];
    }
    public Hand(Card card1, Card card2){
        this.hand = new Card[2];
        this.hand[0] = card1;
        this.hand[1] = card2;
    }

    public void concatHand(Hand handTwo){
        Hand newHand = new Hand(this.hand.length + handTwo.hand.length);
        for (int i = 0; i < newHand.hand.length; i++) {
            if (i < this.hand.length){
                newHand.hand[i] = this.hand[i];
            }
            else {
                newHand.hand[i] = handTwo.hand[i- this.hand.length];
            }
        }
        this.hand = newHand.hand;
    }

    public Card[] getHand() {
        return hand;
    }
    public void war(Player pl1, Player pl2){
        System.out.println("*** This is a war! ***");
        Hand warHand = new Hand(this.hand);
        Card pl1Card = null;
        Card pl2Card = null;

        for (int i = 0; i < 3; i++) {

            pl1Card = pl1.pickCard(pl1.getNextCardIndex());
            pl2Card = pl2.pickCard(pl2.getNextCardIndex());
            Hand newHand = new Hand(pl1Card, pl2Card);
            warHand.concatHand(newHand);
        }

        if (pl1.getNextCardIndex() >= 3 && pl2.getNextCardIndex() >=3){
            int result = pl1Card.compareCards(pl2Card);
            if (result == 1){
                pl1.takeHand(warHand.getHand());
            }
            if (result == -1){
                pl2.takeHand(warHand.getHand());
            }
            if (result == 0){
                warHand.war(pl1, pl2);
            }
        }
        else {
            System.out.println("Not enough cards for war");
        }
    }
}
