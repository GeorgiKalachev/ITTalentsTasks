package test2.dokumentsTask;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Shkaf {


    private String name;
    private Set<Document> documents;

    private Map<String, Map<LocalDate, Set<Document>>> catalog = new HashMap<>();

    public Shkaf(String name) {
        this.name = name;
        this.documents = new HashSet<>();
        this.catalog = new HashMap<>();
    }

    public void addDocument(Document document) {

        // check if type is there
        if (!catalog.containsKey(document.getFirmName())) {
            catalog.put(document.getFirmName(), new HashMap<>());
        }

        // check if kind is there
        if (!catalog.get(document.getFirmName()).containsKey(document.getDateMade())) {
            catalog.get(document.getFirmName()).put(document.getDateMade(), new HashSet<>());
        }

        catalog.get(document.getFirmName()).get(document.getDateMade()).add(document);
        System.out.println(document.getFirmName() + " firm, date : " + document.getDateMade()
                + " , name : " + document.getDocName() + ", added to storage.");
    }


    public void printAll() {
        for (Map.Entry<String, Map<LocalDate, Set<Document>>> e : catalog.entrySet()) {
            System.out.println(e.getKey() + ":");
            Map<LocalDate, Set<Document>> documentsByDate = e.getValue();
            for (Map.Entry<LocalDate, Set<Document>> e1 : documentsByDate.entrySet()) {
                System.out.println("\t" + e1.getKey() + ":");
                Set<Document> documentName = e1.getValue();
                documentName.stream()
                        .sorted((d1, d2) -> d1.getDocName().compareTo(d2.getDocName()))
                        .forEach(d -> System.out.println("\t  " + d.getDocName() + " name. "));

            }
        }
    }

    public void stats1() {
//3. Да се покаже колко документа има за дадена фирма
        System.out.println("Count documents -- Stats 1 ---");
        for (Map.Entry<String, Map<LocalDate, Set<Document>>> e : catalog.entrySet()) {
            System.out.print(e.getKey() + " has : ");
            int total = 0;
            for (Set<Document> docByDate : e.getValue().values()) {
                total += docByDate.size();
            }
            System.out.println(total + " num docs.");

        }
    }

    public void stats2() {
        //Да се покаже колко документа има за подадена дата (независимо от фирмата)
        System.out.println("Count documents by Date -- Stats 2 ---");

        catalog.values().stream()
                .flatMap(m -> m.entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        TreeMap::new,
                        Collectors.summingInt(entry -> entry.getValue().size())))
                .forEach((date, count) -> System.out.println(date + " - " + count + " documents"));
    }

    public void stats3() {

        //Да се покаже за колко дни общо има документи за дадена фирма
        System.out.println("Count documents bay Date and by nums -- Stats 3 ---");
        for (Map.Entry<String, Map<LocalDate, Set<Document>>> e : catalog.entrySet()) {
            System.out.print(e.getKey() + " has : " + e.getValue().size() + " days ,");
            int total = 0;
            for (Set<Document> docByDate : e.getValue().values()) {
                total += docByDate.size();
            }
            System.out.println(total + " num docs.");

        }
    }

    public void stats4(LocalDate first, LocalDate second) {

        //Да се покажат всички документи между две дати
        System.out.println("Count documents between two dates -- Stats 4 ---");

        int sum = 0;
        for (Map.Entry<String, Map<LocalDate, Set<Document>>> e : catalog.entrySet()) {

            Map<LocalDate, Set<Document>> documentsByDate = e.getValue();
            for (Map.Entry<LocalDate, Set<Document>> e1 : documentsByDate.entrySet()) {
                if (e1.getKey().isAfter(first) && e1.getKey().isBefore(second)) {
                    sum += e1.getValue().size();
                }
            }
        }
        System.out.println(" Documents between : " + first + " and " + second + " are - " + sum);
    }

    public void stats5(Document document) {

        //7. Да се добави функционалност за изтриване на подаден документ
        System.out.println("Delete document  -- Stats 5 ---");

        System.out.println("Document : " + document.getDocName() + ", from firm : " + document.getFirmName() + " - deleted !");
        catalog.get(document.getFirmName()).get(document.getDateMade()).remove(document);
    }

    public void stats6() {

        // Да се прелее колекцията в сет с всички документи, сортирани по име
        System.out.println("Move documents to Set and sort them by name  -- Stats 6 ---");
        Set<Document> allDocuments = new HashSet<>();
        for (Map<LocalDate, Set<Document>> dateMap : catalog.values()) {
            for (Set<Document> documents : dateMap.values()) {
                allDocuments.addAll(documents);
            }
        }

        allDocuments.stream()
                .sorted(Comparator.comparing(Document::getDocName))
                .forEach(document -> System.out.println(document.getDocName()));

        Set<Document> documents = catalog.values().stream()
                .flatMap(m -> m.values().stream())
                .flatMap(Collection::stream)
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Document::getDocName))));

        documents.forEach(d -> System.out.println(d.getDocName()));
        /*

            Map<String, Document> documentMap = new HashMap<>();
                 Добавяне на данни към documentMap

                 Създаване на HashSet с елементи от documentMap, сортирани по име
            Set<Document> documentSet = new TreeSet<>(Comparator.comparing(Document::getName));
                documentSet.addAll(documentMap.values());
         */
    }

    public void stats7() {

        //. Да се прелее колекцията в сет с всички документи, сортирани по дата
        System.out.println("Move documents to Set and sort them by Date -- Stats 7 ---");
        Set<Document> allDocuments = new HashSet<>();
        for (Map<LocalDate, Set<Document>> dateMap : catalog.values()) {
            for (Set<Document> documents : dateMap.values()) {
                allDocuments.addAll(documents);
            }
        }

        allDocuments.stream()
                .sorted(Comparator.comparing(Document::getDateMade))
                .forEach(document -> System.out.println(document.getDocName() + " , date : " + document.getDateMade()));
    }


    //Да се прелее колекцията в мап с всички документи, групирани само по фирма

    public void stats8() {

        System.out.println("Move collection  to map with documents, groupe only by firm -- Stats 8  ---");
        Map<String, Set<Document>> firmDocs = catalog.values().stream()
                .flatMap(dateMap -> dateMap.values().stream().flatMap(Set::stream))
                .collect(Collectors.groupingBy(Document::getFirmName, Collectors.toSet()));

        firmDocs.forEach((firm, docsByDate) -> {
            System.out.println(firm);
            docsByDate.stream()
                    .map(Document::getDocName)
                    .sorted()
                    .forEach(docName -> System.out.println("   - " + docName));
        });

        System.out.println("Second way ------ -- 2 --- ---------");

        for (Map.Entry<String, Map<LocalDate, Set<Document>>> entry : catalog.entrySet()) {
            String firmName = entry.getKey();
            System.out.println("Firm name: " + firmName);
            Map<LocalDate, Set<Document>> documentsByDate = entry.getValue();
            for (Map.Entry<LocalDate, Set<Document>> documentsEntry : documentsByDate.entrySet()) {

                Set<Document> documents = documentsEntry.getValue();
                for (Document document : documents) {
                    System.out.println("\t \t " + document.getDocName());
                }
            }
        }

    }

    //11. Да се прелее колекцията в мап с всички документи, групирани по дата

        public void stats9(){

            System.out.println("Move collection  to map with documents, groupe only by Date -- Stats 9  ---");

            Map<LocalDate, List<Document>> docsByDate = catalog.values().stream()
                    .flatMap(map -> map.entrySet().stream())
                    .flatMap(entry -> entry.getValue().stream())
                    .collect(Collectors.groupingBy(Document::getDateMade));

            for (Map.Entry<LocalDate, List<Document>> entry : docsByDate.entrySet()) {
                System.out.println(entry.getKey());
                for (Document doc : entry.getValue()) {
                    System.out.println("  - " + doc.getFirmName() + ": " + doc.getDocName());
                }
            }

        }

    public void stats10() {

        //12. Да се създаде мап с подписани документи, който има същата структура като
        //оригиналния. Да се създаде метод „подпиши документ“, който вади документът от
        //първия мап и го слага във втория.


    }
}
