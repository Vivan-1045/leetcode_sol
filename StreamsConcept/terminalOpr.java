package StreamsConcept;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class terminalOpr {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        //1. collect()
        list.stream().collect(Collectors.toList());
        list.stream().toList();

        //2. forEach()
        list.stream().forEach(System.out::println);

        //3. reduce()
        System.out.println(list.stream().reduce(Integer::sum).get());

        //4. anyMatch(), allMatch(), noneMatch()
        boolean b = list.stream().anyMatch(x -> x % 2 == 0);
        boolean b1 = list.stream().allMatch(x -> x % 3 == 0);
        boolean b2 = list.stream().noneMatch(x -> x % 5 == 0);
        System.out.println(b2);

        //5. findFirst(), findAny()
        System.out.println(list.stream().findFirst().get());
        System.out.println(list.stream().findAny().get());

        //Example 1
        List<String> list1 = Arrays.asList("Ana","Aman","Naman","Rohit","Surya","Bob");
        list1.stream().filter(x->x.length()>3).forEach(System.out::println);
        System.out.println(list1.stream().filter(x->x.length()>3).toList());


        //Example 2
        List<Integer> list2 = Arrays.asList(1,9,3,5,6,4,8,2);
        System.out.println(list2.stream().map(x->x*x).sorted().toList());

        //Example 3
        List<Integer> list3 = Arrays.asList(1,2,3,4,5,6,7,8);
        System.out.println(list3.stream().reduce(Integer::sum).get());

        //Example 4
        String s = "Hello world, lets grind the leetcode LLL";
        System.out.println(s.toLowerCase().chars().filter(x->x=='l').count());
    }
}
