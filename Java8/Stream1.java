package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Stream1 {
    public static void main(String[] args) {
        //Feature introduced in java 8
        //Process collections of data in a functional and declarative manner.
        //Simplify data processing.
        //Embrace functional programming.
        //Improve readability and maintainability.
        //Enable easy parallelism without using multithreading.

        //What is Stream?
        //Sequence of element supporting various operations.
        //how to use streams
        //source , intermediate operation and terminal operation

        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.stream().filter(x->x%2==0).count();
        System.out.println(list.stream().filter(x->x%2==0).count());

        //Creating Streams
        // 1. From collections
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream = list.stream();

        // 2. From Arrays
        String[] array = {"a", "b", "c"};
        Stream<String> stream1 = Arrays.stream(array);

        // 3. Using Stream.of()
        Stream<String> stream2 = Stream.of("a", "b");

        // 4. Infinite streams
        Stream.generate(() -> 1);
        Stream.iterate(1, x -> x + 1);
        
    }
}
