package GasStation;

import java.util.Random;

public class Car extends Thread{

    private int id;
    private String name;
    private GasStation station;
    private String gas;
    private int litresToLoad;
    private Column column = null;

    public Car(String name,GasStation station) {
        this.name = name;
        this.station = station;
        this.gas = getRandomGas();
        this.litresToLoad = new Random().nextInt(15,40);
    }


    public Column getColumn() {
        return column;
    }

    private String getRandomGas() {
        int chance = new Random().nextInt(3);
        switch (chance){
            case 0 -> {
                return "GAS";
            }
            case 1 -> {
                return "BENZIN";
            }
            default-> {
                return "DISEL";
            }
        }
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getGas() {
        return gas;
    }

    public int getLitresToLoad() {
        return litresToLoad;
    }

    @Override
    public void run() {
            while (true) {
                for (Column c : station.getColumns()) {
                    if (c.isEmpty()) {
                        c.putCar(this);
                        System.out.println(name + " is going on  " + c.getName());
                    }
                }

            }

    }
}
