package Threads.homeworkThreads.parts;

public class Tyre extends Part {
    public Tyre() {
        super("Tyre");
    }

    @Override
    public int getTimeToFinish() {
        return 2000;
    }
}
