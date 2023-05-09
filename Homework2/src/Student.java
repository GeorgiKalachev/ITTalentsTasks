public class Student {

    private String name;
    private String subject;
    private double grade;
    private int yearInCollage;
    private int age;
    private boolean isDegree;
    private double money;

    public void setName(String name) {
        if(!name.isBlank() ){
            this.name = name;
        }
    }

    public void setSubject(String subject) {
        if(!subject.isBlank()){
            this.subject = subject;
        }
    }

    public void setGrade(double grade) {
        if (grade >= 2 && grade <= 6 ){
            this.grade = grade;
        }
        else {
            System.out.println("not available grade");
        }
    }

    public void setYearInCollage(int yearInCollage) {
        if(yearInCollage > 0 && yearInCollage < 5 ) {
            this.yearInCollage = yearInCollage;
        }
        else {
            System.out.println("not available year");
        }
    }

    public void setDegree(boolean degree) {
        isDegree = degree;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public double getGrade() {
        return grade;
    }

    public int getYearInCollage() {
        return yearInCollage;
    }

    public int getAge() {
        return age;
    }

    public boolean isDegree() {
        return isDegree;
    }

    Student(){
        this.grade = 4;
        this.yearInCollage = 1;
        this.money = 0;
    }
    Student(String name,String subject, int age,boolean isDegree){
        this();
        this.name = name;
        this.subject = subject;
        this.age = age;
        this.isDegree = isDegree;
    }

    void upYear(){
        if (isDegree){
            System.out.println("Student has Degree.");
        }else {
            yearInCollage++;
            isDegree = yearInCollage >= 4;
            System.out.println(this.name + " is in " + yearInCollage + " year in collage.");
        }
    }

    double receiveScholarship (double min,double amount){
        if ( this.grade >= min && this.age < 30){
            this.money += amount;
        }
        return this.money;
    }
}
