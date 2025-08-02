package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class lazyEvaluations {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Aman","Naman","Rohit","Hardik","Surya","Tilak","Bob");

        Stream<String> stringStream = list.stream().filter(name -> {
            System.out.println("Filtering : " + name);
            return name.length() > 3;
        });

        System.out.println("Before terminal Operations");

        List<String> res = stringStream.collect(Collectors.toList());
        System.out.println("After terminal Operations");
        System.out.println(res);


    }
}
