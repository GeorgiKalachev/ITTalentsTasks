public class Computer {

    /*
    year – числова стойност, показваща година на производство на
компютъра
price – числова стойност (не е задължително да е цяло число),
показваща цената на компютъра
isNotebook – булева стойност – дали компютъра е преносим или не
hardDiskMemory – числова стойност за размера на хардиска
freeMemory – числова стойност, показваща размера на свободната
памет
operationSystem – текстово поле за операционната система на
компютъра
*/

    int year;
    double price;
    boolean isNotebook;
    double hardDiskMemory;
    double freeMemory;
    String operationSystem;


    Computer(){
        isNotebook = false;
        operationSystem = "WinXP";
    }

    Computer(int year,double price,double hardDiskMemory,double freeMemory){
        this();
        this.year = year;
        this.price = price;
        this.hardDiskMemory = hardDiskMemory;
        this.freeMemory = freeMemory;
    }
    Computer(int year,double price,boolean isNotebook,double hardDiskMemory,double freeMemory,
             String operationSystem){
        this.year = year;
        this.price = price;
        this.isNotebook = isNotebook;
        this.hardDiskMemory = hardDiskMemory;
        this.freeMemory = freeMemory;
        this.operationSystem = operationSystem;
    }

    int comparePrice(Computer c){
        if (price > c.price){
            return -1;
        }
        if (price < c.price){
            return 1;
        }
        return 0;

    }
/*
Класът да дефинира следните методи:
-метод changeOperationSystem(newOperationSystem), който сменя
стойността на полето operationSystem със стойността, подадена като
параметър.
*/

    void changeOperationSystem (String newText){

        this.operationSystem = newText;
    }
    /*
-метод useMemory(memory), който намалява свободната памет
(freeMemory) със стойността, подадена като аргумент.
Ако стойността на аргумента е по-голяма от свободната памет,
извежда съобщение "Not enough free memory!"
*/

    void useMemory(int minus){
        if ( freeMemory - minus > 0){
            this.freeMemory -= minus;
        }else {
            System.out.println("Not enough free memory!");
        }
    }


}
