package StreamsConcept;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class PrimitiveStreams {
    public static void main(String[] args) {
       int[] arr = {1,2,3,4,5};
        IntStream stream = Arrays.stream(arr);

        IntStream range = IntStream.range(1, 10);
        IntStream range1 = IntStream.rangeClosed(1,10);
        System.out.println(range.boxed().toList());
        System.out.println(range1.boxed().toList());

        DoubleStream doubles = new Random().doubles(5);
//        System.out.println(doubles.sum());
//        System.out.println(doubles.max());
//        System.out.println(doubles.min());
//        System.out.println(doubles.average());
//        System.out.println(doubles.boxed().toList());
        IntStream ints = new Random().ints(10);
        System.out.println(ints.boxed().toList());


    }
}
