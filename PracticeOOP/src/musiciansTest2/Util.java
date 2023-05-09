package musiciansTest2;

import java.util.Random;

public class Util {

    public static String[] DuhovKind = {"TROMPET", "TROMBON", "TUBA", "FLEITA", "KLARINET"};
    public static String[] ElKind = {"SINTEZATOR","BASSKITARA","ELECCIGULKA"};
    public static String[] KlavKind = { "ORGAN","PIANO","AKORDEON" };
    public static String[] StrunniKind = { "CIGULKA","VIOLA","KONTRABAS","ARFA","KITARA","GYDULKA" };
    public static String[] UdarKind = { "BARABANI","TARAMBUKA","TUPAN","DAIRE"};

    private static final String[] NAMES = {"Gosho","Pesho","Tisho","Krisi","Tanq","Alex","Vayne"};
    private static final String[] EVENTNAME = {"Burgas","Kokoland","Laplandia","Planinsko","MorskiEvent","Baseina","Banketa"};
    private static final String[] ADRESS = {"bulevard G","Stadiona ","Boqna strqha 10","Slatina 15","lis ulica stzy1",
            "ulica panagiurska 289","pavetata 7882"};
    private static final String[] KIDNAMES = {"malkiq Gosho","malkiq Pesho","malkiq Tisho","malkiq ","malkiq Tanq","malkiq Alex","malkiq Vayne"};

    public static String getRandomUdarKind() {
        return UdarKind[new Random().nextInt(UdarKind.length)];
    }
    private static final String[] PHONES = {"0883415762","0883415749","0882415777","0883413774","0883415732","0883415861","0882415172"};
    public static String getRandomStrunnKind() {
        return StrunniKind[new Random().nextInt(StrunniKind.length)];
    }
    public static String getRandomKlavishKind() {
        return KlavKind[new Random().nextInt(KlavKind.length)];
    }
    public static String getRandomDuhovKind(){
        return DuhovKind[new Random().nextInt(DuhovKind.length)];
    }
    public static String getRandomElekKind() {
        return ElKind[new Random().nextInt(ElKind.length)];
    }
    public static String getRandomName() {
        return NAMES[new Random().nextInt(NAMES.length)];
    }

    public static String getRandomKidName() {
        return KIDNAMES[new Random().nextInt(KIDNAMES.length)];
    }
    public static String getRandomPhone() {
        return PHONES[new Random().nextInt(PHONES.length)];
    }


    public static String getRandomEventName() {
        return EVENTNAME[new Random().nextInt(EVENTNAME.length)];
    }
    public static String getRandomAdress() {
        return ADRESS[new Random().nextInt(ADRESS.length)];
    }

}
