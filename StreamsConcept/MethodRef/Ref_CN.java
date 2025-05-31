package StreamsConcept.MethodRef;

interface MessageHere{
    Message message(String msg);
}
class Message{
    public Message(String msg){
        System.out.println(msg);
    }
}

public class Ref_CN {
    public static void main(String[] args) {
        MessageHere hii = Message::new;  //ClassName::new
        hii.message("Hii...");
    }
}
