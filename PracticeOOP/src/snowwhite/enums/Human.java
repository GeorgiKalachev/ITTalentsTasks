package snowwhite.enums;

public class Human {

    public void react(Event event){
        switch (event){
            case FLOOD: System.out.println("Davim se!"); break;
            case FIRE: System.out.println("Purlim se!"); break;
            case TORNADO: System.out.println("Vrutkame se!"); break;
            default:
                System.out.println("Ne ni puka!");
        }

    }

}
