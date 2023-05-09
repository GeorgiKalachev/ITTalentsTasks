package streamsCollections.krasiSrc.main2;

class Demo2 {

    public static void main(String[] args) {

//        List<Present> presents = new ArrayList<>();
//        presents.add(new Present("p1", 100));
//        presents.add(new Present("p2", 80));
//        presents.add(new Present("p3", 40));
//        presents.add(new Present("p4", 75));
//        presents.add(new Present("p5", 35));
//        presents.add(new Present("p6", 10));
//        presents.add(new Present("p7", 89));
//        presents.add(new Present("p8", 71));

        // give me 4 presents cheaper than 50lv
//        int cheap = 0;
//        for(Iterator<Present> it = presents.iterator(); it.hasNext()){
//            Present p = it.next();
//            if(p.getPrice() < 50){
//                cheap++;
//                System.out.println(p.getName());
//                if(cheap == 4){
//                    break;
//                }
//            }
//        }
//
//        presents.stream()
//                .filter(p -> p.getPrice() < 50)
//                .limit(4)
//                .forEach(p -> System.out.println(p));
//
//        // give me 5 cheapest dolls
//
//        for(Present p : presents){
//        for(Iterator<Present> it = presents.iterator(); it.hasNext();){
//            Present p = it.next();
//            if(!p.getName().equals("Doll")){
//                it.remove();
//            }
//        }
//        presents.sort((o1, o2) -> Double.compare(o1.getPrice(), o2.getPrice()));
//        for (int i = 0; i < Math.min(presents.size(), 5); i++) {
//            System.out.println(presents.get(i));
//        }

//
//        presents.stream()
//                .filter(p -> p.getName().equals("Doll"))
//                .sorted((o1, o2) -> Double.compare(o1.getPrice(), o2.getPrice()))
//                .limit(5)
//                .forEach(p -> System.out.println(p));
//
//

//
//        // give me total price of all trains
//        double totalPrice = 0.0;
//        for(Present p : presents){
//            if(p.getName().equals("Train")){
//                double price = p.getPrice();
//                totalPrice  = totalPrice + price;
//            }
//        }
//        System.out.println(totalPrice);
//
//        System.out.println(presents.stream()
//                .filter(p -> p.getName().equals("Train"))
//                .map(p -> p.getPrice())
//                .reduce(0.0, (total, price) -> total + price));


        // names of presents between 40 and 70 lv

//        for(Present p : presents){
//            if(p.getPrice() >= 40 && p.getPrice() <= 70){
//                System.out.println(p.getName());
//            }
//        }
//
//        List<Present> result = presents.stream()
//                .filter(p -> p.getPrice() >= 40  && p.getPrice() <= 70)
//                .peek(p -> System.out.println(p.getName()))
//                .collect(Collectors.toList());
//        result.clear();


        // avg price of all presents

//        double total = 1.0;
//        for(Present p : presents){
//            total = total * p.getPrice();
//        }
//        System.out.println(total / presents.size());

//        double totalPrice = presents.stream()
//                .map(p -> p.getPrice())
//                .reduce(1.0, (price, total) -> total * price);
//        System.out.println(totalPrice / presents.size());



        // avg price of all presents
        // names of presents between 40 and 70 lv
        // give me 4 presents cheaper than 50lv
        // give me 5 cheapest dolls
        // give me total price of all trains

//        double total3Cheapest = presents.stream()
//                .sorted((o1, o2) -> Double.compare(o1.getPrice(), o2.getPrice()))
//                .limit(3)
//                .map(p -> p.getPrice())
//                .reduce(0.0, (aDouble, aDouble2) -> aDouble + aDouble2);
//
//        System.out.println(total3Cheapest);

//        double total = 0.0;
//        for (int i = 0; i < prices.size(); i++) {
//            double number = prices.get(i);
//            total = total + number;
//        }


//        HashMap<String, Integer> hashMap;

//        System.out.println(result);

//        presents.stream()
//                .sorted((o1, o2) -> Double.compare(o2.getPrice(), o1.getPrice()))
//                .skip(3)
//                .limit(3)
//                .forEach(e -> System.out.println(e.getName()));

//        List<String> names = new ArrayList<>();
//        names.add("Anastasia");
//        names.add("Atanas");
//        names.add("Zori");
//        names.add("Viktor");
//        names.add("Boil");
//        names.add("Yordan");
//        names.add("Darina");
//
//        List<String> result = names.stream()
//                .filter(element -> element.startsWith("A"))
//                .map(element -> element.toUpperCase())
//                .collect(Collectors.toList());
//        System.out.println(result);
//
//
//        System.out.println(names);


//        names.forEach(element -> System.out.println(element));
//
//        for(String element : names){
//            System.out.println(element);
//        }

//        for (int i = 0; i < names.size(); i++) {
//            System.out.println(names.get(i));
//        }
//
//        for(Iterator<String> it = names.iterator(); it.hasNext();){
//            System.out.println(it.next());
//        }

        //remove all that start with A
        //remove all whose length is greater than 10
        //make all uppercase
        //sort them by length
        //retain the first 3
        //sort alphabetically
        //return their length


//        Present p1 = new Present("vlak", 10);
//        Present p2 = new Present("doll", 5);
//
//        TreeSet<Present> presents = new TreeSet<Present>((o1, o2) -> Double.compare(o1.getPrice(), o2.getPrice()));
//        presents.add(p1);
//        presents.add(p2);
//
//        for(Present p : presents){
//            System.out.println(p.getPrice());
//        }


//        TreeMap<String, Integer> map = new TreeMap<>();
//        map.put("Yani", 100);
//        map.put("Ani", 150);
//        map.put("Viki", 200);
//
//        for(String name : map.keySet()){
//            System.out.println(name);
//        }
//
//        for(Iterator<String> it = map.keySet().iterator(); it.hasNext();){
//            System.out.println(it.next());
//        }
//
//        for(int money : map.values()){
//            System.out.println(money);
//        }
//
//        for(Iterator<Integer> it = map.values().iterator(); it.hasNext();){
//            System.out.println(it.next());
//        }
//
//        for(Map.Entry<String, Integer> e : map.entrySet()){
//            System.out.println(e.getKey() + " - " + e.getValue());
//        }
//
//        for(Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator(); it.hasNext();){
//            Map.Entry<String, Integer> e = it.next();
//            System.out.println(e.getKey() + " - " + e.getValue());
//        }
//
//        //city sorted -> a bunch of presents sorted by hasChimney
//        TreeMap<String, TreeSet<Present>> sleigh = new TreeMap<>();
//
//        Comparator<Present> byChimney = (o1, o2) -> {
//            if(Boolean.compare(o1.getOwner.hasChimney(), o2.getOwner.hasChimney() == 0){
//                return 1;
//            }
//            return Boolean.compare(o1.getOwner.hasChimney(), o2.getOwner.hasChimney();
//        });
//
//        sleigh.put("Sofia", new TreeSet<>(byChimney));
//        sleigh.put("Varna", new TreeSet<>(byChimney));
//        sleigh.get("Sofia").add(new Present("Vlak", 10));
//        sleigh.get("Varna").add(new Present("Vlak", 10));
//
//        sleigh.put("Plovdiv", new TreeSet<>(byChimney));
//
//        sleigh.get("Plovdiv").add(new Present("Doll", 10));
//
//        for(String city : cities){
//            sleigh.put(city, new TreeSet<>(byChimney));
//        }
//
//        for(TreeSet<Present> chuval : sleigh.values()){
//            for(Present p : chuval){
//                System.out.println(p);
//            }
//        }
//
//        for(Iterator<TreeSet<Present>> chuvalIt = sleigh.values().iterator(); chuvalIt.hasNext();){
//            TreeSet<Present> chuval = chuvalIt.next();
//            for(Iterator<Present> it = chuval.iterator(); it.hasNext();){
//                Present p = it.next();
//                System.out.println(p);
//            }
//        }
//
//        for(String name : names){
//            if(name.startsWith("P")){
//                names.remove(name);
//            }
//        }
        //sorted -> by criteria in a comparator or comparable
        //ordered -> by entry sequence

        //tree -> sorted
        //hash -> not sorted, not ordered
        //linkedhash -> ordered



    }
}
