package musiciansTest2.cakesTest2.cakes;

public abstract class Cake implements Comparable<Cake>{

    protected String name;
    protected String discription;
    protected double price;
    protected int pieces;
    protected CakeType type;

    private int cakeID;

    public Cake(String name, double price, int pieces,CakeType type) {
        this.name = name;

        this.price = price;
        this.pieces = pieces;
        this.type = type;
        this.discription = name + ", " + type;
        this.cakeID = SweetShop.cakeID++;

    }

    public String getName() {
        return name;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    public double getPrice() {
        return price;
    }


}
