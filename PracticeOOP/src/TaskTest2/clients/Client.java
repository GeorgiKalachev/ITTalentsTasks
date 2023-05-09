package TaskTest2.clients;

import java.util.Objects;

public abstract class Client {

    protected String name;
    protected int age;
    protected boolean isMale;
    private int id;
    protected boolean isAlive = true;

    public static int uniqID = 1;

    public Client(String name, int age, boolean isMale) {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
        this.id = uniqID++;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getName() {
        return name;
    }

    public void isKilled() {
        this.isAlive = false;
    }

    public abstract double payAttraction(double price);

    public boolean isAlive() {
        return isAlive;
    }
}
