public class Main {
    public static void main(String[] args) {

        /*
Да се създадат 2 обекта от тип Computer.
Да се зададат стойности на всеки от компютрите за year, price,
hardDiskMemory, freeMemory, operationSystem.Нека единият компютър
да е лаптоп.
*/


        Computer asus = new Computer();
        asus.year = 2015;
        asus.price = 1000;
        asus.isNotebook = true;
        asus.hardDiskMemory = 4000;
        asus.freeMemory = 500;
        asus.operationSystem = "Windows 10";

        Computer dell = new Computer();
        dell.year = 2017;
        dell.price = 1500;
        dell.hardDiskMemory = 2000;
        dell.freeMemory = 250;
        dell.operationSystem = "Windows 7";

 /* На единия от двата компютъра да се задели памет 100
(чрез метода useMemory), а на другия, да се смени операционната
система (чрез метода changeOperationSystem), след което да се
изведат на екрана всичките полета на двата компютъра.
     */
        asus.useMemory(700);
        dell.changeOperationSystem("Linux");

        System.out.println("Asus -- | -- Dell");
        System.out.println(asus.year + " -- year -- " + dell.year);
        System.out.println(asus.price + " -- price -- " + dell.price);
        System.out.println(asus.isNotebook + " -- isNotebook -- " + dell.isNotebook);
        System.out.println(asus.operationSystem + " -- Op System -- " + dell.operationSystem);
        System.out.println(asus.freeMemory + " -- free Mem -- " + dell.freeMemory);
        System.out.println(asus.hardDiskMemory + " -- hard Disk Mem -- " + dell.hardDiskMemory);

        System.out.println();
        System.out.println("-------  ---   TASK  2  ---  ---------");
        System.out.println();


        GSM motorola = new GSM();
        motorola.model = "Motorola";
        motorola.hasSimCard = true;
        motorola.simMobileNumber = "0883567891";
        motorola.ougtoingCallsDuration = 0;
        motorola.lastIncomingCall = new Call();
        motorola.lastOutgoingCall = new Call();

        GSM nokia = new GSM();
        nokia.model = "Nokia";
        nokia.hasSimCard = true;
        nokia.simMobileNumber = "0882567892";
        nokia.ougtoingCallsDuration = 0;
        nokia.lastOutgoingCall = new Call();
        nokia.lastIncomingCall = new Call();

        nokia.call(motorola, 4);
        nokia.call(nokia, 2);
        nokia.call(motorola, 10);
        nokia.printInfoForTheLastOugoingCall();
        nokia.printInfoForTheLastIncomingCall();
        motorola.printInfoForTheLastIncomingCall();
        motorola.printInfoForTheLastOugoingCall();
        System.out.println(nokia.getSumForCall());
        nokia.removeSimCard();
        nokia.call(motorola, 5);
        nokia.insertSimCard("0811111111");
        nokia.call(motorola, 5);
        nokia.printInfoForTheLastOugoingCall();
        motorola.call(nokia,6);
        motorola.call(motorola,10);
        nokia.call(motorola,5);
        nokia.printInfoForTheLastOugoingCall();
        nokia.printInfoForTheLastIncomingCall();
        motorola.printInfoForTheLastIncomingCall();
        motorola.printInfoForTheLastOugoingCall();
        System.out.println(nokia.getSumForCall());
        System.out.println(motorola.getSumForCall());

    }


}