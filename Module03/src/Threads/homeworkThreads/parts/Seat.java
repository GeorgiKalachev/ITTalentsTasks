package Threads.homeworkThreads.parts;

public class Seat extends Part {
    public Seat() {
        super("Seat");
    }

    @Override
    public int getTimeToFinish() {
        return 3000;
    }
}
