package war;

import java.util.Random;

public class Pack {
    private Card[] deck = new Card[52];
    private boolean isShuffled = false;
    
    public Pack generateDeck(){
        int cardIndex = 0;
        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < 13; i++) {
                    deck[cardIndex++] = new Card(i+1, k+1);
            }
        }
        return this;
    }
    public void printDeck(){
        for (int i = 0; i < deck.length; i++) {
            deck[i].printCard();
        }
    }
    public void shuffleDeck(){
        Random ran = new Random();
        for (int i = 0; i < this.deck.length; i++) {
            int randomInd = ran.nextInt(52);
            Card temp = this.deck[randomInd];
            this.deck[randomInd] = this.deck[i];
            this.deck[i] = temp;
        }
        isShuffled = true;
    }
    public void dealToPlayers(Player pl1, Player pl2){
        System.out.println("Let's deal the deck");
        int index = 0;
        for (int i = this.deck.length-1; i >= 1; i-=2) {
            pl1.setCardInCards(index,this.getDeck()[i]);
            System.out.print(pl1.getName() + " ");
            pl1.getCards()[index].printCard();
            System.out.println();
            pl2.setCardInCards(index,this.getDeck()[i-1]);
            System.out.print(pl2.getName() + " ");
            pl2.getCards()[index].printCard();
            System.out.println();
            index++;
        }
        System.out.println("Dealing cards to players is over.");
    }

    public boolean isShuffled() {
        return isShuffled;
    }

    public Card[] getDeck() {
        return deck;
    }
}
