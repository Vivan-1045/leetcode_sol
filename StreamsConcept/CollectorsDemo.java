package StreamsConcept;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsDemo {
    public static void main(String[] args) {
        //Collectors it the utility class
        //Provide a set of method to create common collectors

        //1. Collecting to a list
        List<String> list = Arrays.asList("Rahul", "Aman", "Vivek", "Naman", "Ankit");
        List<String> v = list.stream().filter(x -> x.startsWith("V")).collect(Collectors.toList());
        System.out.println(v);

       //2. Collecting to a Set
        List<Integer> list1 = Arrays.asList(1, 2, 3, 1, 2, 3);
        Set<Integer> collect = list1.stream().collect(Collectors.toSet());
        System.out.println(collect);

        //3. Collecting to a specific element
        ArrayDeque<String> collect1 = list.stream().collect(Collectors.toCollection(() -> new ArrayDeque<>()));

        //4. Joining Strings
        // Concatenate string element into a single string
        String collect2 = list.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
        System.out.println(collect2);

        //5. Summarizing data
        List<Integer> list2 = Arrays.asList(1, 3, 5, 6, 2, 4, 8, 9);
        IntSummaryStatistics collect3 = list2.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println("Count : "+ collect3.getCount() );
        System.out.println("Sum : "+ collect3.getSum());
        System.out.println("Average : "+ collect3.getAverage());
        System.out.println("Max : "+ collect3.getMax());
        System.out.println("Min : "+ collect3.getMin());

        //6. Calculating Average
        Double collect4 = list2.stream().collect(Collectors.averagingInt(x -> x));
        System.out.println("Average : "+ collect4);

        //7. Counting Elements
        Long collect5 = list2.stream().collect(Collectors.counting());
        System.out.println("Count : "+ collect5);

        //8. Grouping Elements
        List<String> list3 = Arrays.asList("Java", "Hello", "world", "java","Collecting");
        System.out.println(list3.stream().collect(Collectors.groupingBy(String::length)));
        System.out.println(list3.stream().collect(Collectors.groupingBy(String::length,Collectors.joining(", "))));
        System.out.println(list3.stream().collect(Collectors.groupingBy(String::length,Collectors.counting())));
        TreeMap<Integer, Long> collect6 = list3.stream().collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.counting()));
        System.out.println(collect6);

        //9. Partitioning elements
        System.out.println(list3.stream().collect(Collectors.partitioningBy(x->x.length() > 4)));

        //10. Mapping and collecting
        System.out.println(list3.stream().collect(Collectors.mapping(String::toUpperCase,Collectors.toList())));

        //Example 1. Collecting names by length
        List<String> list4 = Arrays.asList("Rahul", "Anju", "Naman", "Deepak");
        System.out.println(list4.stream().collect(Collectors.groupingBy(String::length)));

        //Example 2. Counting word occurrences
        String st = "Hello java world";
        System.out.println(Arrays.stream(st.split(" ")).collect(Collectors.groupingBy(x->x,Collectors.counting())));

        //Example 3. Partition even and odd
        List<Integer> list5 = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(list5.stream().collect(Collectors.partitioningBy(x->x%2==0)));

        //Example 4. Summing values in map
        Map<String,Integer> mp = new HashMap<>();
        mp.put("Apple", 40);
        mp.put("Mango",20);
        mp.put("Banana",30);
        System.out.println(mp.values().stream().reduce(Integer::sum).get());
        System.out.println((Integer) mp.values().stream().mapToInt(x -> x).sum());

        //Example 5. Creating a Map from Stream
        List<String> list6 = Arrays.asList("Apple", "Mango", "Banana", "Cherry");
        System.out.println(list6.stream().collect(Collectors.toMap(String::toUpperCase, String::length)));

        //Example 6. word count
        List<String> list7 = Arrays.asList("Java", "C++", "C", "C++", "Python", "Java");
        System.out.println(list7.stream().collect(Collectors.groupingBy(String::toUpperCase,Collectors.counting())));
        System.out.println(list7.stream().collect(Collectors.toMap(String::toUpperCase,V->1,(x,y)->x+y)));
    }

}
