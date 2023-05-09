package JSON;

    import com.google.gson.Gson;

    public class Demo {
        public static void main(String[] args) {
            // създаване на обект, който ще се сериализира към JSON формат
            Person person = new Person("Иван", "Иванов", 30);

            // създаване на Gson обект
            Gson gson = new Gson();

            // сериализиране на обекта към JSON формат
            String json = gson.toJson(person);

            // извеждане на JSON документа
            System.out.println("what");
            System.out.println(json);
            System.out.println("no");
        }
    }

    class Person {
        private String firstName;
        private String lastName;
        private int age;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }
    }
