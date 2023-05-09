package practice;

public enum Color {

    //Singleton, Multiton (Object pool)
    YELLOW(1),  BLACK(3), RED(2),BLUE(4), ORANGE(5);

    private int id;

    Color(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
