package main;

import practice.Color;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

public class Demo2 {

    public static void main(String[] args) {

        Comparator<Product> byNameAndExpDate = (o1, o2) -> {
            if(o1.getName().compareTo(o2.getName()) == 0){
                return o1.getColor().compareTo(o2.getColor());
            }
            return o1.getName().compareTo(o2.getName());
        };

        TreeSet<Product> products = new TreeSet<>(byNameAndExpDate);
        TreeSet<Product> products2 = new TreeSet<>(byNameAndExpDate);

        products.add(new Product("p1", 3, LocalDate.now().plusDays(1), Color.YELLOW));
        products.add(new Product("p1", 3, LocalDate.now().plusDays(1), Color.YELLOW));
        System.out.println(products.size());


        products.stream()
                .map(p -> p.getColor())
                .distinct()
                .forEach(c -> System.out.println(c));
    }

        /*
        List of Products
                    - name
                    - price
                    - exp date
                    - color

            + give me all purple products that expire within a week
            + give me total price of all yellow products whose name starts with S
            + give me the second two cheapest pink products
            + give me the names in upper case of all presents sorted by color and name (if color is equal)
            + give me the names of 3 newest (biggest exp date) products
            + give me the total colors of all products
            + give me the total number of products that have odd prices
            + wildcard 1
            + wildcard 2
            + wildcard 3
         */
}
