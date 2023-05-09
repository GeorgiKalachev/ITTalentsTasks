package Homework17;

public interface INotepad {



    void addTextToPage(String text, int num);

    void addTextReplace(String text,int num);

    void deleteText(int num);

    void printAllPages();

    void searchWord(String word);

    void printPagesWithDigtits();
}
