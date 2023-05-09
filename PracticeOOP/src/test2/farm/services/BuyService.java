package test2.farm.services;

public class BuyService extends Service{

    private String product;
    private int quantity;

    public BuyService(String product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public ServiceType getType() {
        return ServiceType.BUY;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProduct() {
        return product;
    }
}
