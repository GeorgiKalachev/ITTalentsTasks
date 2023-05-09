package Shot;

public class Shop {

    private String name = "Coffee shop";
    private Drink[] drinks;
    private Sandwich[] sandwich;


    Shop(int drinks,int sandwiches){
        if(drinks > 0 && sandwiches > 0) {
            this.drinks = new Drink[drinks];
            this.sandwich = new Sandwich[sandwiches];
        }
        for (int i = 0; i < this.drinks.length; i++) {
            this.drinks[i] = new Drink();
        }
        for (int i = 0; i < this.sandwich.length; i++) {
            this.sandwich[i] = new Sandwich();
        }

    }

    public int getDrinks() {
        int total = 0;
        for (int i = 0; i < this.drinks.length; i++) {
            if (drinks[i].isItSparkling()){
                total++;
            }
        }
        return total;
    }
    public int getSandwiches() {
        int total = 0;
        for (int i = 0; i < this.sandwich.length; i++) {
            if (sandwich[i].isHasMeat()){
                total++;
            }
        }
        return total;
    }

    public Sandwich[] getSandwich() {
        return sandwich;
    }
}
