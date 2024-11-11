import java.util.Arrays;

public class leetcode_1616 {
    public static void main(String[] args) {
        String a = "abda";
        String b = "acmc";
        if(a.length()==1){
            System.out.println(true);
        }
        StringBuilder as1 = new StringBuilder(b);
        as1.reverse();
//        System.out.println(a);
//        System.out.println(as1);
//        System.out.println(as1.charAt(as1.length()-1));
        for(int i =0;i<a.length()-1;i++){
            if ((a.charAt(i) == as1.charAt(i)) || (a.charAt(a.length()-1) == as1.charAt(b.length()-1))){
                System.out.println(true);
                break;
            }
            else{
                System.out.println(false);
                break;
            }

        }
        System.out.println(as1.reverse());


    }
}
