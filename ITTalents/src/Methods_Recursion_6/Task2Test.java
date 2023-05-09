package Methods_Recursion_6;

public class Task2Test {
    public static void main(String[] args) {
        String text = "Today is a good day for a test.Weekend is coming.The room is white.The axe is sharp.";

        printingText(text);
    }

    static void printingText(String text){

        String[] textArr = text.split("\\.");

        int longestSent = 0;
        int sentLongWord = 0;
        int biggestWord = 0;



        for (int i = 0; i < textArr.length; i++) {

            if ( i > 0){
                longestSent = (textArr[i].length() > textArr[longestSent].length()) ? i : longestSent;
            }
            String[] text2 = textArr[i].split(" ");
            for (int j = 0; j < text2.length ; j++) {
                if(text2[j].length() > biggestWord){
                    sentLongWord = i;
                    biggestWord = text2[j].length();
                }
            }
        }
        System.out.println(textArr.length);
        System.out.println(textArr[longestSent]);
        System.out.println(textArr[sentLongWord]);

    }
}
