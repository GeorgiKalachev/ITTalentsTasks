package consulting010823;

public class Test1Task2 {

    public static void main(String[] args) {

        String text = "Today is a good day for a test. Weekend is coming. The room is white. The axe is sharp.";
        disectText(text);
    }

    static void disectText(String text){
        String[] sentences = text.split("\\.");
        System.out.println("Total sentences = " + sentences.length);

        String longestWord = "";
        String sentenceWithLongestWord = "";
        String longestSentence = "";
        for (int i = 0; i < sentences.length; i++) {
            String sentence = sentences[i];
            String[] words = sentence.split(" ");
            for (int j = 0; j < words.length; j++) {
                String word = words[j];
                if(word.length() > longestWord.length()){
                    longestWord = word;
                    sentenceWithLongestWord = sentence;
                }
        }
            if(sentence.length() > longestSentence.length()){
                longestSentence = sentence;
            }
        }
        System.out.println("Longest sentence: " + longestSentence);
        System.out.println("Sentence with the longest word: " + sentenceWithLongestWord.strip());
    }
}
