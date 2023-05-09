package Rakia;

import java.io.File;
import java.time.LocalDateTime;

public class Reporter extends Thread{

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(3000);
                File f = new File(LocalDateTime.now().toString() + ".txt");

            }
        } catch (InterruptedException e) {
            System.out.println("fack");
        }
    }
}
