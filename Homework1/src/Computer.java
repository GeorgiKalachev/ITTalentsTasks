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
    int price;
    boolean isNotebook;
    int hardDiskMemory;
    int freeMemory;
    String operationSystem;

/*
Класът да дефинира следните методи:
-метод changeOperationSystem(newOperationSystem), който сменя
стойността на полето operationSystem със стойността, подадена като
параметър.
*/

    void changeOperationSystem (String newText){

        operationSystem = newText;
    }
    /*
-метод useMemory(memory), който намалява свободната памет
(freeMemory) със стойността, подадена като аргумент.
Ако стойността на аргумента е по-голяма от свободната памет,
извежда съобщение "Not enough free memory!"
*/

    void useMemory(int minus){
        if ( freeMemory - minus > 0){
            freeMemory -= minus;
        }else {
            System.out.println("Not enough free memory!");
        }
    }


}
