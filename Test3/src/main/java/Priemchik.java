import java.time.LocalDateTime;

public class Priemchik extends Thread{

    private Serviz serviz;

    public Priemchik(String name,Serviz serviz) {
        setName(name);
        this.serviz = serviz;
    }

    @Override
    public void run() {

        while (true){

            Car car = serviz.getCarsComing();

            int carID = DBManager.getInstance().saveCar(car);


            Order order = new Order(car.getID(), LocalDateTime.now());
            serviz.takeCarToDiagnostic(order);

            //При постъпване на кола, тя се обработва от приемчик, който проверява дали колата идва за
            //първи път в сервиза.
            //• Ако автомобил с такъв регистрационен номер не е идвал, то той се добавя в базата данни.
            //• Ако автомобил с такъв регистрационен номер вече съществува в базата, то се проверява
            //дали телефонът в базата данни е актуален и ако не, се актуализира. (10т)
            //След това приемчикът създава поръчка за този автомобил, записва поръчката в базата данни,
            //като за нея подава само ID-то на автомобилът и датата на регистрация. Накрая приемчикът
            //добавя поръчката в списък с поръчки за диагностика в сервиза. (10т)

        }
    }
}
