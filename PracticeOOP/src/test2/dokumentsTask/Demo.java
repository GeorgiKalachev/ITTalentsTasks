package test2.dokumentsTask;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class Demo {
    public static void main(String[] args) {



        Shkaf shkaf = new Shkaf("shkafa");
        LocalDate date = LocalDate.of(2023,2,10);

        String[] firms = {"IT OOD ","Music OOD","Restaurants OOD","MiniMask EOOD"};

        for (int i = 0; i < 22; i++) {
            String firm = firms[new Random().nextInt(firms.length)];

            if ( new Random().nextBoolean() ){
                date = date.plusDays(1);
            }else {
                date = date.minusDays(1);
            }

            Document document = new Document(firm,date,"document" + i);
            shkaf.addDocument(document);
        }

        shkaf.printAll();

        shkaf.stats1();
        shkaf.stats2();

        shkaf.stats3();
        LocalDate da1 =  LocalDate.of(2023, 2,11);
        LocalDate da2 =  LocalDate.of(2023, 2,13);
        shkaf.stats4(da1,da2);

        Document nov = new Document("IT OOD ",da2,"noviq");
        shkaf.addDocument(nov);
        shkaf.printAll();

        shkaf.stats5(nov);
        shkaf.printAll();

        shkaf.stats6();


        Document nov1 = new Document("IT OOD ",da2,"noviq1111111");

        Document nov2 = new Document("IT OOD ",da2,"noviq222222222");
        shkaf.addDocument(nov1);
        shkaf.addDocument(nov);
        shkaf.addDocument(nov2);
        shkaf.stats7();
        shkaf.stats8();
        shkaf.stats9();
        shkaf.stats10();

    }
}
