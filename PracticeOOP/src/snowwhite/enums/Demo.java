package snowwhite.enums;

public class Demo {

    public static void main(String[] args) {

        Nature nature = new Nature();

        nature.addHuman(new Human());
        nature.addHuman(new Human());

        nature.fire();
    }
}
