package Java8;
import java.util.Base64;

@FunctionalInterface
interface funtional{
    int calhere(int a,int b);
    static void hello(){
        System.out.println("Hii i'm static method and called without any instance of class and can't be override by any other subclass");
    }
}
interface inetrfaceA{
    default void defMethod(){
        System.out.println("I'm default method! of A");
    }
}
interface interfaceB{
    default void defMethod(){
        System.out.println("I'm default method! of B");
    }
}

class implmentation implements interfaceB,inetrfaceA{
    @Override
    public void defMethod() {
        interfaceB.super.defMethod();
        inetrfaceA.super.defMethod();
    }
}
public class functional_Interface {
    public static void main(String[] args) {

        funtional.hello();

        funtional calSum = Integer::sum;
        funtional calSub = (a,b)-> a-b;
        funtional calMul = (a,b)-> a*b;
        funtional calDiv = (a,b)-> a/b;
        System.out.println(calSum.calhere(8,9));

        implmentation obj = new implmentation();
        obj.defMethod();

        //Switch expression
        int day = 2;
        String dayName = switch (day){
            case 1 -> "MONDAY";
            case 2 -> {
                System.out.println("Second day of week");
                yield "TUESDAY"; //It returns the values from case block
            }
            case 3 -> "WEDNESDAY";
            default -> "Invalid";
        };
        System.out.println(dayName);

        //TextBlock keyword
        String textBlock = """
                A paragraph has three major parts- 
                1. Topic sentence 
                2. Supporting sentences 
                3. Concluding sentence 
                1. Topic Sentence: This is the first sentence of a paragraph and serves as its main idea or focus. 
                   It tells the reader what the paragraph will be about. 
                   A strong topic sentence is clear and specific, setting the stage for the information that will follow. 
                   For example, if you’re writing about the benefits of exercise, your topic sentence might be, 
                   “Regular exercise improves overall health in sev...
                
                What Makes a Paragraph Very Good...
                """;

        // Var keyword
        var hii = "how are you?";
        System.out.println(hii);
        System.out.println(textBlock);

        //Base64 encoded
        String st = "Hii how are you?";
        String encoded = Base64.getEncoder().encodeToString(st.getBytes());
        byte[] res = Base64.getDecoder().decode(encoded);
        String decoded = new String(res);
        System.out.println("Encoded String : "+encoded);
        System.out.println("Decoded String : "+decoded);



    }
}
