package Java8.MethodRef;

interface SayAble{
    void say();
}
public class  Ref_STM {
    public static void saySomething(){
        System.out.println("Hii,I'm Static method");
    }

    public static void main(String[] args) {
        SayAble sayAble = Ref_STM::saySomething; //ContainingClass::staticMethodName
        sayAble.say();
    }
}
