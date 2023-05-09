package test2.prezidenti;

import test2.prezidenti.candidats.Candidat;

public class Biuletina {

    private Candidat candidat;
    private String city;
    private boolean isValid;

    public Biuletina(Candidat candidat, String city, boolean isValid) {
        this.candidat = candidat;
        this.city = city;
        this.isValid = isValid;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public String getCity() {
        return city;
    }

    public boolean isValid() {
        return isValid;
    }
}
