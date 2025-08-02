package Java8;

import java.util.Arrays;
import java.util.List;

class Abc<T> {
    private T value;

    public void setValue(T val){
        this.value = val;
    }

    public T getValue(){
        return value;
    }
}


public class Diamond_Syntax {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("a","b","c","d");

        list.forEach(System.out::println);

        Abc<Integer> a = new Abc<>();
        Abc<String> s = new Abc<>();
        Abc<Character> c = new Abc<>();

        a.setValue(78);
        s.setValue("Vivek");
        c.setValue('$');

        System.out.println(a.getValue());
        System.out.println(s.getValue());
        System.out.println(c.getValue());


    }
}
