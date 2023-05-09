package Threads.homeworkThreads.parts;

public class Frame extends Part {
    public Frame() {
        super("Frame");
    }

    @Override
    public int getTimeToFinish() {
        return 5000;
    }
}
