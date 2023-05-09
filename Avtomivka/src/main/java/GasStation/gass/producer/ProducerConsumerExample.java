package GasStation.gass.producer;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        int maxSize = 5;
        Thread producerThread = new Thread(new Producer(queue, maxSize));
        Thread consumerThread = new Thread(new Consumer(queue, maxSize));
        producerThread.start();
        consumerThread.start();
    }



}
