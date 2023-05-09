package Homework14;

import Homework14.people.Employee;
import Homework14.people.Person;
import Homework14.people.Student;

public class Demo {
    public static void main(String[] args) {

        Person[] people = new Person[10];

        int idx = 0;
        for (int i = 0; i < 2; i++) {
            people[idx++] = new Person(Util.getRandomName(), Util.getRandomAge(), Util.getGender());
            people[idx++] = new Student(Util.getRandomName(), Util.getRandomAge(), Util.getGender(), 4);
            people[idx++] = new Employee(Util.getRandomName(), Util.getRandomAge(), Util.getGender(), 80);
        }

        for (int i = 0; i < people.length; i++) {

            if (people[i] != null) {
                System.out.println("-------- kidsGarden.Person -- " + (i + 1) + " ---------");
                people[i].showInfo();
                people[i].getOverTime(2);

            }
        }

    }
}
