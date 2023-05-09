package Rakia;

public abstract class Person extends Thread {

    private String name;
    private int age;
    private Rakidjiiinica factory;

    public Person(String name,int age,Rakidjiiinica factory){
        setName(name);
        this.age = age;
        this.factory = factory;
    }



    public int getAge() {
        return age;
    }

    public Rakidjiiinica getFactory() {
        return factory;
    }
}
