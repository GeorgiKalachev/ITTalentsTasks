package test2.prezidenti.candidats;

import test2.prezidenti.Util;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Random;

public abstract class Candidat {

    public String getName() {
        return this.name;
    }

    public enum EDUCATION {NoEDUC,SREDNO,OSNOVNO,VISHE}
    public static int unicID = 1;

    protected String name;
    protected EDUCATION education;
    protected double money;
    protected int id;
    protected boolean isMoshenik;

    protected HashSet<Glasopodavatel> glasopodavateli = new HashSet<>();

    public Candidat(String name, EDUCATION education, double money) {
        this.name = name;
        if(isValidEducation(education)) {
            this.education = education;
        }
        this.money = money;
        this.id = unicID++;
    }

    public EDUCATION getEducation() {
        return education;
    }

    public double getMoney() {
        return money;
    }

    public HashSet<Glasopodavatel> getGlasopodavateli() {
        return glasopodavateli;
    }

    protected abstract boolean isValidEducation(EDUCATION education) ;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidat candidat = (Candidat) o;
        return id == candidat.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }



    //Всеки кандидат организира изборна кампания. Кампанията има срок (от дата, до дата) и бюджет,
    //с който разполага. Кампанията на кандидата генерира гласоподаватели, които по-късно ще
    //гласуват на изборите. Кампаниите се създват за срок между 20 и 25 дни.

    public void organizeCampaigne(LocalDate dateStart,LocalDate dateEnd) {

        //TODO validate dates from 20-25 days
        Random r = new Random();

        if (!this.isMoshenik) {
            while (dateStart.isBefore(dateEnd)) {
                for (int i = 0; i < 100; i++) {

                    int chance = r.nextInt(3);
                    Glasopodavatel glasopodavatel;
                    char[] gender = {'m', 'f'};
                    switch (chance) {
                        case 0 -> glasopodavatel = new Neuk(Util.getRandomName(),
                                gender[r.nextInt(2)], Util.getRandomCITY(), this, false);
                        case 1 -> glasopodavatel = new Sreden(Util.getRandomName(),
                                gender[r.nextInt(2)], Util.getRandomCITY(), this, false);
                        default -> glasopodavatel = new Zamojen(Util.getRandomName(),
                                gender[r.nextInt(2)], Util.getRandomCITY(), this, false);
                    }
                    this.glasopodavateli.add(glasopodavatel);
                }
                dateStart = dateStart.plusDays(1);
            }
        }else {

            while (dateStart.isBefore(dateEnd)) {
                for (int i = 0; i < 120; i++) {

                    if(i>60 && this.money < 50){
                        System.out.println("no money ");
                        break;
                    }

                    int chance = r.nextInt(3);
                    Glasopodavatel glasopodavatel;
                    char[] gender = {'m', 'f'};
                    switch (chance) {
                        case 0 -> glasopodavatel = new Neuk(Util.getRandomName(),
                                gender[r.nextInt(2)], Util.getRandomCITY(), this, i > 60 );
                        case 1 -> glasopodavatel = new Sreden(Util.getRandomName(),
                                gender[r.nextInt(2)], Util.getRandomCITY(), this, i > 60);
                        default -> glasopodavatel = new Zamojen(Util.getRandomName(),
                                gender[r.nextInt(2)], Util.getRandomCITY(), this, i > 60);
                    }
                    if(i>60){
                        this.money -= r.nextInt(30,50);
                    }
                    this.glasopodavateli.add(glasopodavatel);
                }
                dateStart = dateStart.plusDays(1);
            }


        }
    }
}
