public class GSM {
    /*
        model – модел на телефона
    hasSimCard – дали в телефона е заредена SIM карта
    simMobileNumber – номер на SIM картата(телефонен номер), ако е
    заредена такава.
    outgoingCallsDuration – общото време (в минути) на изходящите
    повиквания
    lastIncomingCall – последното входящо повикване
    lastOutgoingCall – последното изходящо повикване
         */
    String model;
    boolean hasSimCard;
    String simMobileNumber;
    int ougtoingCallsDuration;
    Call lastIncomingCall;
    Call lastOutgoingCall;


    /*
    - insertSimCard(simMobileNumber) – метода задава номер(сим карта)
на телефона. Да се провери дали подаденият номер е валиден
(започва с 08 и се състои от 10 цифри). Ако номерът е валиден, го
задава на телефона и задава стойност true на полето hasSimCard
     */
    void insertSimCard(String simMobileNumb) {
        if (simMobileNumb.startsWith("08") && simMobileNumb.length() == 10) {
            hasSimCard = true;
            simMobileNumber = simMobileNumb;
        } else {
            hasSimCard = false;
            System.out.println("Invalid number entered!");
        }

    }

    /*
    - removeSimCard() - премахва сим картата от телефона (задава false
на полето hasSimCard)
     */
    void removeSimCard() {
        simMobileNumber = "null";
        hasSimCard = false;
    }

    /*
    - call( receiver, duration) – В тялото му да се направят проверки за:
• дали въведената дължина на разговора е валидна
• дали двата телефона (този за който се извиква метода и
този към който се прави обаждането) не са един и същ телефон
• дали и двата телефона имат сим карта
     */
    void call(GSM reciever, int duration) {
        if ((duration <= 0 || simMobileNumber.equals(reciever.simMobileNumber) ||
                !hasSimCard || !reciever.hasSimCard)) {
            System.out.println("Cannot call");

        } else {
            Call call1 = new Call();
            call1.durationMin = duration;
            call1.caller = simMobileNumber;
            call1.reciever = reciever.simMobileNumber;

            reciever.lastIncomingCall = call1;
            lastOutgoingCall = call1;

            ougtoingCallsDuration += duration;
        }

    }

    /*
    Да се направи и метод getSumForCall(), който връща сумата,
начислена за изходящите повиквания на телефона (общото време на
изходящите повиквания по цената за минута - priceForAMinute).

     */
    int getSumForCall() {

        if (ougtoingCallsDuration >= 1) {
            return ougtoingCallsDuration * lastOutgoingCall.priceForAMin;
        }
        return -1;
    }

    /*
        Да се направят два метода
printInfoForTheLastOutgoingCall() и
printInfoForTheLastIncomingCall()
които извеждат информация за последното изходящо/входящо
повиквана на телефона (ако има такова)
         */
    void printInfoForTheLastOugoingCall() {
        System.out.println("Info for last outgoing call.");
        System.out.println("Price : " + lastOutgoingCall.priceForAMin);
        System.out.println("Receiver : " + (lastOutgoingCall.reciever == null ? "N/A" : lastOutgoingCall.reciever));
        System.out.println("Caller : " + (lastOutgoingCall.caller == null ? "N/A" : lastOutgoingCall.caller));
        System.out.println("Duration : " + (lastOutgoingCall.durationMin == 0 ? "N/A" : lastOutgoingCall.durationMin));

    }

    void printInfoForTheLastIncomingCall() {
        System.out.println("Info for last incoming call.");
        System.out.println("Price : " + lastIncomingCall.priceForAMin);
        System.out.println("Receiver : " + (lastIncomingCall.reciever == null ? "N/A" : lastIncomingCall.reciever));
        System.out.println("Caller : " + (lastIncomingCall.caller == null ? "N/A" : lastIncomingCall.caller));
        System.out.println("Duration : " + (lastIncomingCall.durationMin == 0 ? "N/A" : lastIncomingCall.durationMin));

    }


}
