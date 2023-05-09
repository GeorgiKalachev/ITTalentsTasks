package main.cleaning;

public class Demo {

    public static void main(String[] args) {

        /*
         Химическо чистене. Клиенти. Всеки клиент има дрехи. Дрехите биват
        панталон, риза, сако. Всяка дреха се чисти различно време и на различна
        цена.

        Клиент може да даде всичките си дрехи на химическо чистене. Дава ги
        наведнъж.
        Химическото изпира дрехите и връща обща сума, дължима от клиента.

        Химическото пази колко време общо е чистило дрехи и кой вид
        дреха колко пъти е чистена (колко дрехи от всеки вид). Също пази общия
        брой клиенти, както и клиентът с най-скъпото чистене.

        Бонус - да се изведе статистика колко ризи, панталони и сака са били чистени.
         */

        DryCleaning dryCleaning = new DryCleaning("Vasko i dushteri");
        Client sokol = new Client();
        Client naime = new Client();
        dryCleaning.receiveOrder(sokol);
        dryCleaning.receiveOrder(naime);
        dryCleaning.receiveOrder(sokol);
        dryCleaning.receiveOrder(naime);

        dryCleaning.showTotalCleaningTime();
        dryCleaning.showClothesByType();

        dryCleaning.showTotalClients();

        dryCleaning.getMostGenerousClient();

    }
}
