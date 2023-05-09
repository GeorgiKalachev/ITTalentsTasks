package Homework14.people;

public class Person {

    protected String name;
    protected int age;
    protected boolean isMale;

    public Person(String name, int age, boolean isMale) {
        //TODO validate
        this.name = name;
        this.age = age;
        this.isMale = isMale;
    }

    public void showInfo() {
        System.out.println("Name : " + this.name);
        System.out.println("Age : " + this.age);
        System.out.println("Gander : " + ((this.isMale) ? "Male" : "Female"));
    }

    protected int getAge() {
        return age;
    }

    public void getOverTime(double hours) {
    }
}
