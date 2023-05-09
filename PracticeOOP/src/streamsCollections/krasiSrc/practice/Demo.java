package practice;

public class Demo {

    public static void main(String[] args) {

        eat("musli");

    }

//    public static void eat(String[] foods){
//
//    }

    public static void eat(String... foods){//variable agruments -> varargs -> String[]
        if(foods.length == 0){
            System.out.println("Nothing to eat");
            return;
        }
        for(String food : foods){
            System.out.println("eating " + food);
        }
    }
}
