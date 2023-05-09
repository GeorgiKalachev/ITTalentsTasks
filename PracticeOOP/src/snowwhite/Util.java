package snowwhite;

import snowwhite.presents.Present;

import java.util.Random;

public final class Util {

    private static final String[] CITIES = {"Sofia", "Varna","Plovdiv", "V. Tyrnovo", "Burgas", "Kilifarevo", "Pernik"};
    private static final String[] COLORS = {"RED", "GREEN","BLACK", "BLUE", "YELLOW", "PURPLE", "PINK"};
    private static final String[] CLOTHES_DIMENSIONS = {"S", "M","L", "XL"};
    private static final String[] DOLL_DIMENSIONS = {"60x40", "30x30","90x30", "120x190"};
    private static final String[] DWARF_NAMES = {"Gimli", "Vasli","Iliichi", "Georgi", "Sokolchi", "Mariichi", "Teodorchi"};
    private Util() {}

    public static String getRandomDollDimensions(){
        return getRandomString(DOLL_DIMENSIONS);
    }

    public static int getRandomInt(int min, int max){
        return new Random().nextInt(min, max+1);
    }

    public static String getRandomClothesDimensions(){
        return getRandomString(CLOTHES_DIMENSIONS);
    }

    public static String getRandomDwarfName(){
        return getRandomString(DWARF_NAMES);
    }

    public static String getRandomColor(){
        return getRandomString(COLORS);
    }
    public static String getRandomCity(){
        return getRandomString(CITIES);
    }

    public static String getRandomString(String[] arr){
        return arr[new Random().nextInt(arr.length)];
    }

    public static Present.PresentType getRandomPresentType(){
        return Present.PresentType.values()[new Random().nextInt(Present.PresentType.values().length)];
    }
}
