package Lesson_7_Algorythms;

public class CheckTask2 {
    public static void main(String[] args) {

        String test1 = "Simple sentence that is first.";
        String test2 = "Another sentence that is second.";
        String test3 = "Third sentence that is last.";

        printingWords(test1, test2, test3);
    }

    static void printingWords(String text1, String text2, String text3) {

        String[] text = text1.split(" ");
        int countWord = 0;
        int biggestWord = text[0].length();
        int bigWordElem = 0;
        StringBuilder words = new StringBuilder();

        for (int i = 0; i < text.length; i++) {

            if (text2.contains(text[i]) && text3.contains(text[i])) {
                countWord++;
                words.append(text[i]).append(" ");
            }
            if (text[i].length() > biggestWord) {
                bigWordElem = i;
                biggestWord = text[i].length();
            }

        }
        System.out.println(words);
        System.out.println(countWord);
        System.out.println(text[bigWordElem]);
    }
}
