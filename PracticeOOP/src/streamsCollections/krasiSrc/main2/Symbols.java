package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Symbols {

    public static void main(String[] args) {

        String text = "ala balall";

        Map<Character, Integer> symbols = new HashMap<>();
        text = text.toLowerCase();
        for(int i = 0; i < text.length(); i++){
            char letter = text.charAt(i);
            if(!Character.isLetter(letter)){
                continue;
            }
            if(symbols.containsKey(letter)){
                symbols.put(letter, symbols.get(letter)+1);
            }
            else {
                symbols.put(letter, 1);
            }
        }

//        for(Map.Entry<Character, Integer> e : symbols.entrySet()){
//            System.out.println(e.getKey() + " - " + e.getValue());
//        }

        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(symbols.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        for(Map.Entry e : list){
            System.out.println(e.getKey() + " - " + e.getValue());
        }
    }
}
