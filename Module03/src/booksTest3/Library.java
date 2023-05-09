package booksTest3;

import booksTest3.reads.Book;
import booksTest3.reads.Magazine;
import booksTest3.reads.Readable;
import booksTest3.reads.SchoolBook;

import java.time.LocalDate;
import java.util.*;

public class Library {

    List<Readable> books = new ArrayList<>();
    Map<Readable.TYPE,TreeSet<Readable>> catalog = new TreeMap<>();

    private void addBookToCatalog(){

        for (Readable.TYPE type : Readable.TYPE.values()) {
            catalog.put(type, new TreeSet<>());
        }
        for (Readable book: this.books) {
            catalog.get(book.getType()).add(book);
        }
    }

    public Readable getBook(){
        Readable book = books.get(books.size()-1);
        books.remove(book);
        return book;
    }
    public void printTreeSet(){

        for (Map.Entry<Readable.TYPE,TreeSet<Readable>> type : this.catalog.entrySet()) {
            System.out.println(type.getKey().toString());
            TreeSet<Readable> list = type.getValue();
            for (Readable book : list) {
                System.out.print("   ");
                book.getInfo();
            }
        }

    }

    public void addBooks(){

        LocalDate date = LocalDate.now();
        String[] izdatelstvo = {"Meks OOD","Ahmed OOD","DETEX AD"};
        String[] author = {"Stefan Karadja ","Ahmed Dogan","Delena Kancheva","Roby Williams"};
        Readable book;
        for (int i = 0; i < 100; i++) {
            int chance = new Random().nextInt(3);
            switch (chance){

                case 0 -> book = new Book("Book " +i,i%2==0 ? date : date.plusDays(3),
                        izdatelstvo[new Random().nextInt(izdatelstvo.length)],
                        author[new Random().nextInt(author.length)]);
                case 1 -> book = new Magazine("Book " +i,i%2==0 ? date : date.plusDays(3),
                        izdatelstvo[new Random().nextInt(izdatelstvo.length)]);
                default -> book = new SchoolBook("Book " +i,i%2==0 ? date : date.plusDays(3),
                        izdatelstvo[new Random().nextInt(izdatelstvo.length)]);
            }
            this.books.add(book);
            System.out.println("Library added new "+ book.getName() + book.getClass().getName() + " date  "
            + book.getDatePublished() + " from : " + book.getIzdatelstvo());

        }

        addBookToCatalog();
    }
}
