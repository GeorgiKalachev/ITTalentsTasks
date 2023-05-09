package Homework17.pads;

import Homework17.INotepad;

import java.util.ArrayList;

public class SimpleNotepad implements INotepad {

    private ArrayList<Page> notepad;
    private int index = 0;

    public SimpleNotepad(){
        notepad = new ArrayList<>();
    }


    @Override
    public void addTextToPage(String text, int num) {

        if(this.notepad.size() < num){
            String pageIdx = Integer.toString(++index);
            Page page = new Page(pageIdx);
            page.addText(text);
            this.notepad.add(page);

        }else {
            this.notepad.get(num-1).addText(text);
        }

    }

    @Override
    public void addTextReplace(String text,int num) {
        if (notepad.size() < num){
            System.out.println("invalid page num.");
        }else {
            this.notepad.get(num - 1).removeText();
            addTextToPage(text, num );
        }
    }

    @Override
    public void deleteText(int num) {
        this.notepad.get(num-1).removeText();
    }

    @Override
    public void printAllPages() {
        for (Page page : notepad) {
            page.showPageInfo();
        }
    }

    @Override
    public void searchWord(String word) {
        for (Page page : notepad) {
            if (page.searchWord(word)) {
                System.out.println("Page contain --- " + word);
                page.showPageInfo();
            }
        }
    }

    @Override
    public void printPagesWithDigtits() {
        for (Page page : notepad) {
            if (page.containsDigit()) {
                System.out.println("Page contains digits --- ");
                page.showPageInfo();
            }
        }
    }
}
