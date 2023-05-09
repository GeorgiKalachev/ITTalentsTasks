package kidsGarden;

public class Garden {

    private final Kid[] kids;
    private final Teacher teacher;

    public Kid[] getKids() {
        return kids;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    Garden(Teacher teacher){
        this.teacher = teacher;
        this.kids = new Kid[25];
    }

    public void addKid(Kid kid,int position){
        this.kids[position] = kid;
    }
}
