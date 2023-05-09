import java.util.Arrays;

public class StudentGroup {

    private String groupSubject;
    private final Student[] students;
    private int freeSpaces;

    public String getGroupSubject() {
        return groupSubject;
    }

    public int getFreeSpaces() {
        return freeSpaces;
    }


    public void setGroupSubject(String groupSubject) {
        this.groupSubject = groupSubject;
    }

    StudentGroup(){
        this.freeSpaces = 5;
        this.students = new Student[5];
        System.out.println("Student group created with " + freeSpaces + " free spaces.");
    }
    StudentGroup(String groupSubject){
        this();
        this.groupSubject = groupSubject;
        System.out.println("with name " + groupSubject);
    }

    void addStudent(Student s){
        if(this.freeSpaces > 0 && this.students[this.students.length-this.freeSpaces] == null &&
        s.getSubject().equals(this.groupSubject) && !s.isDegree()){
            students[this.students.length-this.freeSpaces] = s;
            this.freeSpaces--;
            System.out.printf("Student %s added %d free spaces left.\n",s.getName(),freeSpaces);
        }else {
            System.out.println("You shall not passs!");
        }
    }

    void emptyGroup(){
        Arrays.fill(students, null);
        this.freeSpaces = 5;
        System.out.printf("Group %s is empty, with %d free spaces.\n",groupSubject,freeSpaces);
    }

    String theBestStudent(){
        double biggestGrade = students[0].getGrade();
        String bestStudent = students[0].getName();
        for (int i = 0; i < students.length - freeSpaces; i++) {
            if (students[i].getGrade() > biggestGrade){
                biggestGrade = students[i].getGrade();
                bestStudent = students[i].getName();
            }
        }
        return bestStudent;
    }

    void printStudentsInGroup(){
        for (int i = 0; i < students.length-freeSpaces; i++) {
            System.out.println("---  Student " + (i+1) + "   ---");
            System.out.print("name : " + students[i].getName());
            System.out.print(" age : " + students[i].getAge());
            System.out.print(" subject : " + students[i].getSubject());
            System.out.print(" hasDegree : " + students[i].isDegree());
            System.out.print(" grade : " + students[i].getGrade());
            System.out.print(" year in collage : " + students[i].getYearInCollage());
            System.out.println();
        }
    }
}
