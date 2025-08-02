package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOpr {
    public static void main(String[] args) {
        //Intermediate operations are convert the stream into another stream.
        //They are lazy means they are not execute until terminal operations is invoked.

        List<String> nameList = Arrays.asList("Aman","Anju","Mitali","Bhavana","Aradhana","Anju","Anjali");
        nameList.stream().filter(x->x.startsWith("A"));

        //No Filtering at this point

        //1. filter()
        long res = nameList.stream().filter(x->x.startsWith("B")).count();
        Stream<String> res1 = nameList.stream().filter(x -> x.startsWith("A"));
        System.out.println(res);
        res1.forEach(x-> System.out.print(x+", "));

        //2. map()
        Stream<String> stringStream = nameList.stream().map(String::toUpperCase);
        stringStream.forEach(x-> System.out.print(x+", "));

        //3. sort()
        Stream<String> sorted = nameList.stream().sorted();
        Stream<String> sortedUsingComparetor = nameList.stream().sorted((a,b)->a.length()-b.length());
        sortedUsingComparetor.forEach(System.out::println);

        //4. distinct()
        Stream<String> distinct = nameList.stream().distinct();
        System.out.println(nameList.stream().filter(x->x.startsWith("A")).distinct().count());
        distinct.forEach(x-> System.out.print(x+", "));

        //5. limit()
        System.out.println(Stream.iterate(1,x->x+1).limit(20).count());

        //6. skip()
        System.out.println(Stream.iterate(1,x->x+1).skip(10).limit(20).count());

        //7. peek()
        System.out.println(Stream.iterate(1,x->x+1).skip(10).limit(20).peek(System.out::println).count());

        //8. flatMap()
        //Handle streams of collections, list,or arrays where each element is itself a collection
        //flatten nested structure like list inside another list
        //Transform and flatten element at same time

        List<List<String>> list = Arrays.asList(Arrays.asList("Jony","Rohit"),
                Arrays.asList("Surya","Hardik"),
                Arrays.asList("Naman","Tilak"),
                Arrays.asList("Mitchel","Bumrah"),
                Arrays.asList("Ashwani","Bawa")
                );

        System.out.println(list.get(1).get(0));
        System.out.println(list.stream().flatMap(x->x.stream()).map(String::toUpperCase).toList());
    }
}
