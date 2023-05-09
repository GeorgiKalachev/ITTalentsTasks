package test2.prezidenti;

import test2.prezidenti.candidats.Candidat;

import java.util.Random;

public class Util {

    private static final String[] NAMES = {"Gosho","Pesho","Tisho","Krisi","Tanq","Alex","Vayne","RumenRadev","Pyrvanov"};
    private static final String[] CITY = {"SOFIQ","PLOVDIV","VARNA","BURGAS","STARA ZAGORA"};



    public static String getRandomName() {
        return NAMES[new Random().nextInt(NAMES.length)];
    }
    public static String getRandomCITY() {
        return CITY[new Random().nextInt(CITY.length)];
    }

    public static Candidat.EDUCATION getRandomEducation() {
        Random random = new Random();
        Candidat.EDUCATION[] educations = Candidat.EDUCATION.values();
        return educations[random.nextInt(educations.length)];
    }

}
