package musiciansTest2.musicInstrumentsTest2.instruments;

import java.util.Objects;

public abstract class Instrument {


    public enum InstrType { STRUNNI,UDARNI,DUHOVI,KLAVISHNI,ELEKTRONNI}

    private String name;
    private double price;
    private int amountOwn;
    private InstrType type;
    String kind;

    public Instrument(String name, double price,InstrType type,String kind) {
        this.name = name;
        this.price = price;
        this.amountOwn = 0;
        this.type = type;
        this.kind = kind;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instrument that = (Instrument) o;
        return Double.compare(that.price, price) == 0 && amountOwn == that.amountOwn && Objects.equals(name, that.name) && type == that.type && Objects.equals(kind, that.kind);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, amountOwn, type, kind);
    }

    public String getRandomKind(){
        return kind;
     }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getKind() {
        return kind;
    }

    public InstrType getType() {
        return type;
    }
}
