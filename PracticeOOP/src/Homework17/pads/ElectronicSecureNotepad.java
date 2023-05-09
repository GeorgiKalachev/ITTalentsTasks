package Homework17.pads;

import Homework17.IElectronicDevice;
import Homework17.INotepad;

public class ElectronicSecureNotepad extends SecuredNotePad implements INotepad, IElectronicDevice {


    private boolean isStarted;


    @Override
    public void addTextToPage(String text, int num) {
        if (isStarted()){
            super.addTextToPage(text, num);
        }
    }

    @Override
    public void addTextReplace(String text, int num) {
        if (isStarted()) {
            super.addTextReplace(text, num);
        }
    }

    @Override
    public void deleteText(int num) {
        if(isStarted()){
            super.deleteText(num);
        }

    }

    @Override
    public void printAllPages() {
        if(isStarted()) {
            super.printAllPages();
        }
    }

    @Override
    public void start() {
        if(isValidPassword() && !isStarted) {
            isStarted = true;
            System.out.println("Turned On");
        }else {
            System.out.println("Wrong pass or is started");
        }
    }

    @Override
    public void strop() {
        if(isValidPassword() && isStarted) {
            System.out.println("devise is stopped");
            isStarted = false;
        }else {
            System.out.println("Wrong pass or is stopped");
        }
    }

    @Override
    public boolean isStarted() {
        return isStarted;
    }


    @Override
    public void searchWord(String word) {
        if(isStarted() && isValidPassword()) {
            super.searchWord(word);
        }
    }

    @Override
    public void printPagesWithDigtits() {
        if(isStarted() && isValidPassword()) {
            super.printPagesWithDigtits();
        }
    }
}
