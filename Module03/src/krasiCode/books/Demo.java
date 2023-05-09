package krasiCode.books;

import java.util.List;

public class Demo {

    public static void main(String[] args) throws InterruptedException {

        List<Book> books = List.of(new Book(), new Book(), new Book());
        for(Book b : books){
            b.rentBook();
        }

        Thread.sleep(5000);

        for(Book b : books) {
            double price = b.returnBook();
            System.out.println("Price to pay = " + price);
        }

    }
}
