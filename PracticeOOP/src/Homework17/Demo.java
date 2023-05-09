package Homework17;

import Homework17.pads.ElectronicSecureNotepad;
import Homework17.pads.SecuredNotePad;
import Homework17.pads.SimpleNotepad;

import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleNotepad notepad = new SimpleNotepad();


        notepad.addTextToPage("Kvo stava",1);
        notepad.addTextToPage("Nishto stava",2);
        notepad.addTextToPage("epa stava",3);


        notepad.addTextReplace("Smeni li se ? ", 2);
        notepad.deleteText(3);

        notepad.addTextToPage("hodihme za banica, ",3);
        notepad.addTextToPage("kupihme i boza i airAn",3);
        notepad.addTextToPage("mai se smeni Da",2);
        notepad.printAllPages();


        SecuredNotePad secure = new SecuredNotePad();

        secure.addTextToPage("Kvo stava",2);
        secure.addTextToPage("nishto ",2);
        secure.addTextToPage("eeeee stava",2);
        secure.addTextToPage("eeeee stava stavaaaa",3);

        secure.printAllPages();


        ElectronicSecureNotepad elsecure = new ElectronicSecureNotepad();

        elsecure.addTextToPage("Kvo stava",2);
        elsecure.addTextToPage("nishto ",2);

        elsecure.start();
        elsecure.addTextToPage("Kvo stava",2);
        elsecure.addTextToPage("nishto44 ",2);
        elsecure.addTextToPage("nishto44 ",3);
        elsecure.addTextToPage("nishto ",4);

        elsecure.strop();
        elsecure.addTextToPage("Kvo sta5va",2);
        elsecure.addTextToPage("nishto ",2);

        elsecure.start();
        elsecure.printPagesWithDigtits();
        elsecure.searchWord("stava");

    }



}
