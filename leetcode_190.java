import java.util.Scanner;

public class leetcode_190 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Bits here: ");
        String n = sc.next();
        System.out.print("Reversed Bits are here: ");
        ReverseBit(n);
    }
    public static void ReverseBit(String s){
        for (int i = s.length()-1; i >=0; i--) {
            System.out.print(s.charAt(i));
        }
    }
}
