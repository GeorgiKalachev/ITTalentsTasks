package Threads.threadsOnText;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class demo {

    private static final String FILENAME = "war_and_peace1.2.txt";
    public static void main(String[] args) {
        int numThreads = 20; // брой нишки
        int numCommas = 0; // брой запетаи
        long startTime = System.currentTimeMillis(); // запазваме времето преди да започнем

        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }

            String text = sb.toString();
            int chunkSize = (int) Math.ceil(text.length() / (double) numThreads); // размер на частите за обработка

            ExecutorService executorService = Executors.newFixedThreadPool(numThreads); // създаваме пул от нишки
            for (int i = 0; i < numThreads; i++) {
                int startIndex = i * chunkSize;
                int endIndex = Math.min(startIndex + chunkSize, text.length());
                String chunk = text.substring(startIndex, endIndex);

                executorService.execute(new CommaCounterTask(chunk)); // изпълняваме задачите на отделни нишки
            }

            executorService.shutdown();
            while (!executorService.isTerminated()) {
                // изчакваме всички нишки да завършат
            }

            numCommas = CommaCounterTask.getNumCommas(); // събираме резултатите от всички нишки
        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis(); // запазваме времето след като завършим
        long totalTime = endTime - startTime; // изчисляваме времето за изпълнение

        System.out.println("Брой запетаи: " + numCommas);
        System.out.println("Време за изпълнение: " + totalTime + " милисекунди");
    }
            private static class CommaCounterTask implements Runnable {
                private String chunk;
                private static int numCommas = 0;

                public CommaCounterTask(String chunk) {
                    this.chunk = chunk;
                }

                public static int getNumCommas() {
                    return numCommas;
                }

                @Override
                public void run() {
                    for (int i = 0; i < chunk.length(); i++) {
                        if (chunk.charAt(i) == ',') {
                            numCommas++;
                        }
                    }
                }
            }
    }
