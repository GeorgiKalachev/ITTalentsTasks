package Avtomivka;


public class Worker extends Thread {

    public static Avtomivka avtomivka;
    private int ID;
    private int age;

    public Worker(String name, int age){
        setName(name);
        this.age = age;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public void run() {

        }
    }

