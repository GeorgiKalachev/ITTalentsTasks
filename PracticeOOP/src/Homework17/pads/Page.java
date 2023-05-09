package Homework17.pads;



import java.util.ArrayList;

 class Page  {

    private final String name;
    private ArrayList<String> text;

     public Page(String name) {
         this.name = name;
         this.text = new ArrayList<>();
     }

     public void addText(String text){
        this.text.add(text);
    }

     public void removeText() {
         this.text = new ArrayList<>();
     }

     public void showPageInfo(){
         System.out.println("page " + this.name + " : ");
         for (String s : text) {
             System.out.print(s);
             System.out.println();
         }

     }

     public boolean searchWord(String word){
         for (String s : text) {
             if (s.contains(word)) {
                 return true;
             }
         }
         return false;
     }

     public boolean containsDigit(){
         for (String s : text) {
             if (s.matches(".*\\d+.*")) {
                 return true;
             }
         }
         return false;
     }
 }
