package war;

public class War {
    private boolean hasWar;
    public static void main(String[] args) {
        Pack newDeck = new Pack().generateDeck();
//        newDeck.printDeck();
        newDeck.shuffleDeck();
//        newDeck.printDeck();
        Player pl1 = new Player("Peter");
        Player pl2 = new Player("Alex");
        newDeck.dealToPlayers(pl1, pl2);

        while (pl2.getNextCardIndex() >= 0){
            Card pl1Card = pl1.pickCard(pl1.getNextCardIndex());
            System.out.print(pl1.getName() + " - ");
            pl1Card.printCard();
            Card pl2Card = pl2.pickCard(pl2.getNextCardIndex());
            System.out.print(pl2.getName() + " - ");
            pl2Card.printCard();
            Hand hand = new Hand(pl1Card, pl2Card);
            int result = pl1Card.compareCards(pl2Card);
            if (result == 1){
                pl1.takeHand(hand.getHand());
            }
            if (result == -1){
                pl2.takeHand(hand.getHand());
            }
            if (result == 0){
                hand.war(pl1, pl2);
            }
        }
        if (pl1.getTaken().length == pl2.getTaken().length){
            System.out.println("The game ends in a draw");
        }
        else {
            if (pl1.getTaken().length > pl2.getTaken().length){
                System.out.println("The winner is " + pl1.getName());
            }
            else {
                System.out.println("The winner is " + pl2.getName());
            }
        }
        
        
    }


}
