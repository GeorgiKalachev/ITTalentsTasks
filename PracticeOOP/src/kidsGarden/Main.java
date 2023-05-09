package kidsGarden;

public class Main {
    public static void main(String[] args) {

        Teacher missPeligri = new Teacher("Miss Peligri");

        Garden gradina = new Garden(missPeligri);

        int position = 0;
        Kid sisi = new Kid("Sisi",2,true);
        gradina.addKid(sisi,position++);
        Kid krasi = new Kid("Krasi",3,true);
        gradina.addKid(krasi,position++);
        Kid sasho = new Kid("Sasho",4,true);
        gradina.addKid(sasho,position++);
        Kid pipi = new Kid("Pipi",2,true);
        gradina.addKid(pipi,position++);
        Kid liza = new Kid("Liza",2,true);
        gradina.addKid(liza,position++);
        Kid kolio = new Kid("Kolio",3,true);
        gradina.addKid(kolio,position++);
        Kid penko = new Kid("Penko",2,true);
        gradina.addKid(penko,position++);
        Kid gosho = new Kid("Gosho",3,true);
        gradina.addKid(gosho,position++);
        Kid ivan = new Kid("Ivan",2,true);
        gradina.addKid(ivan,position++);
        Kid petya = new Kid("Petya",4,true);
        gradina.addKid(petya,position++);
        Kid ivan2 = new Kid("Ivan2",2,true);
        gradina.addKid(ivan2,position++);
        Kid obiOne = new Kid("ObiOne",3,true);
        gradina.addKid(obiOne,position++);
        Kid omikron = new Kid("Omikron",2,true);
        gradina.addKid(omikron,position++);
        Kid edelvais = new Kid("Edelvais",3,false);
        gradina.addKid(edelvais,position++);
        Kid zevs = new Kid("Zevs",2,false);
        gradina.addKid(zevs,position++);
        Kid ivon = new Kid("Ivon",3,false);
        gradina.addKid(ivon,position++);
        Kid anna = new Kid("Anna",2,false);
        gradina.addKid(anna,position++);
        Kid mimi = new Kid("Mimi",4,false);
        gradina.addKid(mimi,position++);
        Kid veni = new Kid("Veni",4,false);
        gradina.addKid(veni,position++);
        Kid tomas = new Kid("Tomas",2,false);
        gradina.addKid(tomas,position++);
        Kid francia = new Kid("Francia",3,false);
        gradina.addKid(francia,position++);
        Kid aneliq = new Kid("Aneliq",3,false);
        gradina.addKid(aneliq,position++);
        Kid urbano = new Kid("Urbano",4,false);
        gradina.addKid(urbano,position++);
        Kid malemale = new Kid("Maleee",4,false);
        gradina.addKid(malemale,position++);
        Kid talanta = new Kid("Talanta",4,false);
        gradina.addKid(talanta,position);


        Kid mostGiftedKid = sisi;
        int gifts = sisi.getGift();
        int punishedKids = 0;
        Kid mostPunishedKid = sisi;
        int punishments = sisi.getPunishment();
        int bothGiftAndPunished = 0;

        for (int i = 0; i < gradina.getKids().length; i++) {
            for (int j = 0; j < 5; j++) {
                gradina.getTeacher().entertainingKid(gradina.getKids()[i]);
            }
            if (gradina.getKids()[i].getGift() > gifts){
                mostGiftedKid = gradina.getKids()[i];
                gifts = gradina.getKids()[i].getGift();
            }
            if (gradina.getKids()[i].getPunishment() > punishments){
                mostPunishedKid = gradina.getKids()[i];
                punishments = gradina.getKids()[i].getPunishment();
            }
            if (gradina.getKids()[i].getPunishment() > 0){
                punishedKids++;
                if (gradina.getKids()[i].getGift() > 0){
                    bothGiftAndPunished++;
                }
            }
        }
        System.out.println("Most gifted kid : " + mostGiftedKid.getName());
        System.out.println("Number of punished kids : " + punishedKids);
        System.out.println("Most punished kid : " + mostPunishedKid.getName());
        System.out.println("Gifted and punished kids number : " + bothGiftAndPunished);
    }
}
