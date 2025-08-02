package Java8.MethodRef;

interface Dispaly{
    void display();
}
public class Ref_IM {
    public void Display1(){
        System.out.println("Hii,I'm non-static method");
    }

    public static void main(String[] args) {
        Ref_IM ref = new Ref_IM();
        Dispaly dispaly = ref::Display1;  //containingObject::instanceMethodName
        dispaly.display();
    }
}
