package booksTest3;

import booksTest3.reads.Readable;

public class Demo {
    public static void main(String[] args) throws InterruptedException {


        Library library = new Library();

        library.addBooks();

        library.printTreeSet();

        Readable book1 = library.getBook();
        book1.rentBook();

        Thread.sleep(2000);
        System.out.println("------ 2 sec have gone ------");

        Readable book2 = library.getBook();
        book2.rentBook();

        Thread.sleep(2000);
        System.out.println("------ 2 sec have gone ------");

        Readable book3 = library.getBook();
        book3.rentBook();

        book1.returnBook();

        Thread.sleep(5000);
        System.out.println("------ 5 sec have gone ------");

        book2.returnBook();
        book3.returnBook();


    }

}
