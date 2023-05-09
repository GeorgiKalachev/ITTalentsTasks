package musiciansTest2.cakesTest2.cakes;

import musiciansTest2.cakesTest2.cakes.persons.Client;

public class Demo {

    public static void main(String[] args) {

        SweetShop shop = new SweetShop("Sladki Talanti","Manastirski Livadi","0885655523");

        shop.hiringFiveDelivers();

        shop.makingCakes();

        shop.makingClients();

        shop.viewTheMenu();

        shop.clientMakingOrders();

        shop.viewTheMenu();

        shop.amountOfProfit();

        shop.deliversInfo();

        System.out.println(naiProdadena());


    }
    static String naiProdadena(){
        int maxNum = Client.nums[0];
        int maxID = 0;
        for (int i = 0; i < Client.nums.length; i++) {
            if(Client.nums[i] > maxNum){
                maxID = i;
            }
        }
        String type = "";
        switch (maxID){
            case 0 -> type = "Kids Cake";
            case 1 -> type = "Special Cake";
            case 2 -> type = "Standart Cake";
            case 3 -> type = "Wedding Cake";
        }
        return type;
    }
}
