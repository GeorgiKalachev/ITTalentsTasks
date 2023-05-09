package skari;

public class Demo {

    public static void main(String[] args) {

        //........
        Shop shop = new Shop();
        Seller.shop = shop;
        Client.shop = shop;
        SaladCook.shop = shop;
        MeatCook.shop = shop;
        BreadCook.shop = shop;

        shop.open();

        for (int i = 0; i < 3; i++) {
            new Client().start();
        }

    }
}
