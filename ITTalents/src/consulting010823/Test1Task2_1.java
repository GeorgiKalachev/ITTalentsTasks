package consulting010823;

public class Test1Task2_1 {

    public static void main(String[] args) {

        String text = "This test sucks big time";
        text = sort(text);
        System.out.println(text);//big sucks test this time

    }

    static String sort(String text){
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length-1; j++) {
                if(words[j].compareToIgnoreCase(words[j+1]) > 0){
                    String temp = words[j];
                    words[j] = words[j+1];
                    words[j+1] = temp;
                }
            }
        }
        return String.join(" ", words);
    }
}
