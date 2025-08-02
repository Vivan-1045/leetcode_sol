package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ParallelStream {
    public static void main(String[] args) {
        // A type of stream that enables parallel processing of elements
        // Allowing multiple threads to process part of stream simultaneously
        // this can significantly improve performance for large data sets
        // workload is distributed across multiple threads

        long st = System.currentTimeMillis();
        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(20000).toList();
        List<Long> list1 = list.stream().map(ParallelStream::factorial).toList();
        long ed = System.currentTimeMillis();
        System.out.println("Time taken by sequential stream : "+(ed-st)+" ms");



        st = System.currentTimeMillis();
        list1 = list.parallelStream().map(ParallelStream::factorial).toList();
//        list1 = list.parallelStream().map(ParallelStream::factorial).sequential().toList();

        ed = System.currentTimeMillis();
        System.out.println("Time taken by parallel stream : "+(ed-st)+" ms");

        //Parallel stream are most effective for CPU intensive or large dataset where tasks are independent
        //They may add overhead for simple task or small dataset like below example


        //Example cumulative sum
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);
        AtomicInteger sum = new AtomicInteger(0); //Thread safe
        List<Integer> list3 = list2.parallelStream().map(sum::getAndAdd).toList();
        System.out.println(list3); //It gives wrong output since it is not independent


    }

    public static long factorial(int n){
        long ans = 1;
        for (int i = 2;i<=n;i++){
            ans *= i;
        }
        return ans;
    }
}
