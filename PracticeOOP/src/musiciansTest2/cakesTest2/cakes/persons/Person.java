package musiciansTest2.cakesTest2.cakes.persons;

public abstract class Person {
    private String name;
    private String phoneNum;

    public Person(String name, String phoneNum) {
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public String getName() {
        return name;
    }
}
