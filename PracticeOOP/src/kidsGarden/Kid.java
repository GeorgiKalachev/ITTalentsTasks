package kidsGarden;

public class Kid {

    private final String name;
    private final int years;
    private final boolean isGood;
    private int punishment;
    private int gift;

    public Kid(String name, int years, boolean isGood) {
        this.name = name;
        if (isValidYear(years)){
            this.years = years;
        }else {
            this.years = 3;
        }

        this.isGood = isGood;
        this.punishment = 0;
        this.gift = 0;
    }
    private boolean isValidYear(int year){
        return year > 1 && year < 5;
    }

    public void isPunished() {
        this.punishment++;
    }

    public void isGifted() {
        this.gift++;
    }

    public String getName() {
        return name;
    }


    public boolean isGood() {
        return isGood;
    }

    public int getPunishment() {
        return punishment;
    }

    public int getGift() {
        return gift;
    }
}
