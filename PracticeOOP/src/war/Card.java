package war;

public class Card {
    private String rank;
    private String suit;
    private int strength;
    
    public int compareCards(Card opponentCard){
        if (this.strength > opponentCard.strength){
            return 1;
        }
        else {
            if (this.strength < opponentCard.strength){
                return -1;
            }
            else {
                return 0;
            }
        }
    }
    Card(int strength, int suit){
        this.strength = setStrength(strength);
        this.rank = setRank(strength);
        this.suit = setSuit(suit);
    }

    private String setRank(int strength) {
        switch (strength){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                this.rank = String.valueOf(++strength);
                break;
            case 10:
                this.rank = "J";
                break;
            case 11:
                this.rank = "Q";
                break;
            case 12:
                this.rank = "K";
                break;
            case 13:
                this.rank = "A";
                break;
            default:
                System.out.println("Invalid rank value");
                break;
        }
        return this.rank;
    }

    private String setSuit(int suitInt) {
        switch (suitInt){
            case 1:
                this.suit = "club";
                break;
            case 2:
                this.suit = "diamond";
                break;
            case 3:
                this.suit = "heart";
                break;
            case 4:
                this.suit = "spade";
                break;
            default:
                System.out.println("Invalid suite value");
                break;
        }
        return this.suit;
    }

    private int setStrength(int strength) {
        if (strength > 0 && strength < 14){
            this.strength = strength;
        }
        return this.strength;
    }
    public void printCard(){
        System.out.print(rank + " " + suit + " ");
    }
    public void printCardWithSpace(){
        System.out.println(" " + rank + " " + suit);
    }
}
