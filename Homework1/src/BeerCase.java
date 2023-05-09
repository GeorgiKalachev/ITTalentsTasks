public class BeerCase {

    private final Beer[] beers;

    BeerCase(int amount){
        this.beers = new Beer[amount];
        for (int i = 0; i < beers.length; i++) {
            beers[i] = new Beer(3,2);
        }
    }

    void addBeer(){

    }
    void showInfo(){
        int price = 0;
        int litres = 0;
        for (int i = 0; i < beers.length; i++) {
            price += beers[i].getPrice();
            litres += beers[i].getLitres();
        }
        System.out.println("Price for all beers = " + price);
        System.out.println("Litres for all beers = " + litres);

    }

}
