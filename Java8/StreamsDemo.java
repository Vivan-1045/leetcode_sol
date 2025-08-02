package Java8;

import java.util.function.*;

public class StreamsDemo {
    public static void main(String[] args) {

        //Java 8 --> minimal code , functional programming
        //Java 8 --> Lambda expressions , Streams, Date and Time API

        //Topic 1
        //Lambda expression --> Lambda expression is an anonymous function (no return type,no name ,no access modifier)
        //It is used to implement functional interface.
        //Functional Interface --> those interface who have only one abstract method. like runnable interface.

        //Example 1
        Thread t1 = new Thread(()-> System.out.println("Thread t1 is running..."));
        t1.start();

        //Example 2
        Calculator sum = (a,b) -> a+b;
        Calculator sub = (a,b) -> a-b;
        Calculator mul = (a,b) -> a*b;
        Calculator div = (a,b) -> a/b;
        System.out.println(mul.calculate(5,6));

        //Predicate --> Functional interface (boolean valued function)
        Predicate<Integer> predicate = x->x%2==0;
        Predicate<String> isStartWithV = x-> x.toLowerCase().startsWith("v");
        Predicate<String> isEndWithk = x-> x.toLowerCase().endsWith("k");
        System.out.println(isStartWithV.and(isEndWithk).test("vivek"));


        //Functions --> work for you
        Function<Integer,Integer> function = x-> 99%x;
        Function<Integer,Integer> function1 = x-> 9*x;
        System.out.println(function.apply(98));
        System.out.println(function.andThen(function1).apply(100));
        System.out.println(function.compose(function1).apply(100));


        //Consumer --> it consume and does not return anything
        Consumer<Integer> consumer = x-> System.out.println(x);
        Consumer<Integer> consumer1 = System.out::println;
        consumer.accept(52);


        //Supplier --> it does not consume anything but return
        Supplier<String> supplier = ()->"Hello java";
        System.out.println(supplier.get());

        //Combined Example
        Predicate<Integer> isEven = x->x%2==0;
        Function<Integer,Integer> fun1 = x-> x*x;
        Consumer<Integer> consume  = x-> System.out.println(x);
        Supplier<Integer> supplier1 = ()->100;

        if (predicate.test(supplier1.get())){
            consume.accept(fun1.apply(supplier1.get()));
        }


        //BiFunction , BiPredicate ,BiConsumer
        BiPredicate<Integer,String> biPredicate = (x,y)->x==y.length();
        BiConsumer<Integer,Integer> biConsumer = (x,y)-> System.out.println(x+y);
        BiFunction<String,String,Integer> biFunction = (x,y)-> (x+y).length();

        System.out.println(biPredicate.test(5,"abhfd"));
        System.out.println(biFunction.apply("abcdes","hdsfkdsg"));
        biConsumer.accept(5,6);


        //UnaryOperator
        UnaryOperator<Integer> unaryOperator = x->2*x; //Extends Function
        BinaryOperator<Integer> binaryOperator = (x,y)->x+y; //Extends BiFunction

        System.out.println(unaryOperator.apply(5));
        System.out.println(binaryOperator.apply(8,5));

        //<-----------functional interface ends here--------->

    }
}

interface Calculator{
    int calculate(int a, int b);
}