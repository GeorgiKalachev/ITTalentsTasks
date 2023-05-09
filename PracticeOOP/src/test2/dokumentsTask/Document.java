package test2.dokumentsTask;

import java.time.LocalDate;
import java.util.Objects;

public class Document {

    private String firmName;
    private LocalDate dateMade;
    private String docName;
    private int unicID;

    public static int unID = 1;

    public Document(String firmName, LocalDate dateMade, String docName) {
        this.firmName = firmName;
        this.dateMade = dateMade;
        this.docName = docName;

        this.unicID = unID++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return unicID == document.unicID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(unicID);
    }

    public String getFirmName() {
        return firmName;
    }

    public LocalDate getDateMade() {
        return dateMade;
    }

    public String getDocName() {
        return docName;
    }
}
