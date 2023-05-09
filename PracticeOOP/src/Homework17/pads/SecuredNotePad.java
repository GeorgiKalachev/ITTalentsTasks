package Homework17.pads;

import java.util.Scanner;

public class SecuredNotePad extends SimpleNotepad {
    Scanner sc = new Scanner(System.in);
    private final String password;

    public SecuredNotePad(){
        super();
        System.out.println("Enter password for secure notepad");
        this.password = sc.nextLine();
    }

    protected boolean isValidPassword(){
        System.out.println("Enter password for command.");
        return sc.nextLine().equals(password);
    }
    @Override
    public void addTextToPage(String text,int num) {

        if(isValidPassword()){
            super.addTextToPage(text, num);
        }
    }

    @Override
    public void addTextReplace(String text, int num) {
        if(isValidPassword()){
            super.addTextReplace(text, num);
        }

    }

    @Override
    public void deleteText(int num) {
        if(isValidPassword()){
            super.deleteText(num);
        }
    }

    @Override
    public void printAllPages() {
        if(isValidPassword()){
            super.printAllPages();
        }
    }
}
