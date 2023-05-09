package Rakia;

import Rakia.Fruits.Fruit;

public class KazanRakia {


    private int capacity = 0;
    private Fruit fruit = null;
    private final int MAX_CAP = 10;


    public KazanRakia() {

    }

public synchronized void putProduct(Fruit fruit){

        try {
            while (capacity >= MAX_CAP) {
                wait();
            }
            if (capacity == 0) {
                this.fruit = fruit;
            } else if (this.fruit != fruit) {
                throw new UnsupportedOperationException("not suitable kazan!");
            }
            capacity++;
            notifyAll();
        }
        catch (InterruptedException e){
            System.out.println("maika ti");
        }

}


public boolean isFull(){
        return this.capacity == MAX_CAP;
}
    public boolean isEmpty() {
       return this.capacity == 0;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void empty() {
        this.capacity = 0;
        this.fruit = null;
    }
}
