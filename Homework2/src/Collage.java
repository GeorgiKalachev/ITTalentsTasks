public class Collage {
    public static void main(String[] args) {

        Student pesho = new Student("Peter","ITtalents",20,false);
        Student gosho = new Student("Georgi","ITtalents",25,false);
        Student ivan = new Student("Ivan","ITtalents",30,false);
        Student genka = new Student("Genka","ITtalents",39,true);
        Student petya = new Student("Petya","NSA",22,false);
        Student sashka = new Student("Sashka","ITtalents",22,false);
        Student pashka = new Student("Pashka","ITtalents",22,false);
        Student franchesko = new Student("Franchesko","NSA",25,false);
        Student tanq = new Student("Tanq","NSA",35,true);


        pesho.upYear();
        pesho.upYear();
        pesho.upYear();
        pesho.upYear();
        gosho.upYear();
        genka.upYear();
        sashka.upYear();

        System.out.println(pesho.receiveScholarship(3,50) );
        System.out.println(gosho.receiveScholarship(5,20));
        System.out.println(ivan.receiveScholarship(4,50));

        StudentGroup itTalents = new StudentGroup("ITtalents");
        StudentGroup nsa = new StudentGroup("NSA");

        itTalents.addStudent(pesho);
        itTalents.addStudent(gosho);
        itTalents.addStudent(petya);

        nsa.addStudent(petya);
        nsa.addStudent(franchesko);
        nsa.addStudent(tanq);
        itTalents.addStudent(ivan);
        itTalents.addStudent(ivan);
        itTalents.addStudent(genka);
        itTalents.addStudent(sashka);
        itTalents.addStudent(pashka);

        sashka.setGrade(6);
        pesho.setGrade(7);
        franchesko.setGrade(5);
        System.out.println("The best student in " + nsa.getGroupSubject() + " is - " + nsa.theBestStudent());
        System.out.println("The best student in " + itTalents.getGroupSubject() + " is - " + itTalents.theBestStudent());

        nsa.printStudentsInGroup();
        itTalents.printStudentsInGroup();

        itTalents.emptyGroup();
        itTalents.addStudent(pesho);
        itTalents.addStudent(gosho);



    }
}
