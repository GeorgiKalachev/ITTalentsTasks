public class Beer {

    private final int price;
    private final int litres;


    Beer(int price,int litres){
        this.price = price;
        this.litres = litres;
    }
    int getPrice(){
        return price;
    }
    int getLitres(){
        return litres;
    }
}
