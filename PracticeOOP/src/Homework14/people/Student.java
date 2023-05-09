package Homework14.people;

public class Student extends Person {

    private final double score;

    public Student(String name, int age, boolean isMale, double score) {
        super(name, age, isMale);
        this.score = score;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Student score is : " + this.score);
    }
}
