package musiciansTest2.cakesTest2.cakes.persons;

import musiciansTest2.cakesTest2.cakes.Order;
import musiciansTest2.cakesTest2.cakes.SweetShop;
import musiciansTest2.cakesTest2.cakes.Cake;

import java.util.Random;

public class Client extends Person {

    private boolean isCooperative;
    private String adress;
    private double discount;


    public Client(String name, String phoneNum,String adress) {
        super(name, phoneNum);
        this.isCooperative = new Random().nextBoolean();
        this.adress = adress;
        this.discount = new Random().nextInt(50,150);
    }


    public void makeOrder(SweetShop shop) {
        /*
        Ако е корпоративен – да поръча произволен брой (между три и пет) торти от
произволен вид и тип. В такъв случай се създава поръчка, в която влизат
необходимите торти (ако са налични), като също така се причислява доставчик на
произволен принцип, който да занесе тортите. От цената на поръчката се приспадат
процентът отстъпка на корпоративният клиент. Отстъпките биват произволни между
5% и 15%. Доставчикът занася поръчката, при което клиентът му заплаща дължимата
сума заедно с 5% бакшиш. Сумата влиза в касата на сладкарницата, а бакшишът
остава за доставчика.

         */
        Random r = new Random();
        Order order = new Order(this);
        order.setDeliver(shop.getRandomDeliver());
        System.out.print(order.getDeliver().getName() + " delivers : ");

        if(isCooperative()){
            int cakeNum = r.nextInt(3,5);
            if(shop.getCurrCakes().size() < cakeNum){
                System.out.println("Not enogth cakes");
            }else {
                for (int i = 0; i < cakeNum; i++) {
                    Cake cakeCopy = shop.getCake();
                    order.setCakes(cakeCopy);
                    System.out.print("cake - " + cakeCopy.getName());
                    prodadenaTorta(cakeCopy.getName());
                    shop.removeCake(cakeCopy);
                }
                order.setDiscount(order.setPrice() / 0.90);
                order.getDeliver().setTips(order.getPrice() * 0.05);


            }

        }else {
            int cakeNum = r.nextInt(1,3);
            if(shop.getCurrCakes().size() < cakeNum){
                System.out.println("Not enogth cakes");
            }else {
                for (int i = 0; i < cakeNum; i++) {
                    Cake cake = shop.getCake();
                    order.setCakes(cake);
                    System.out.print("cake - " + cake.getName());
                    prodadenaTorta(cake.getName());
                    shop.removeCake(cake);
                }
                int discount = r.nextInt(10,30);
                order.setDiscount(order.setPrice() - discount);
                order.getDeliver().setTips(order.getPrice() * 0.02);
            }
        }
        System.out.println(" for : " + order.getPrice());

        shop.payOrder(order.getPrice());
    }

    public static int[] nums = {0,0,0,0};



    private void prodadenaTorta(String name) {
        switch (name){
            case "Kids Cake" -> nums[0]++;
            case "Special Cake" -> nums[1]++;
            case "Standart Cake" -> nums[2]++;
            case "Wedding Cake" -> nums[3]++;
        }
    }

    public boolean isCooperative() {
        return isCooperative;
    }

    public String getAdress() {
        return adress;
    }
}
