package Bit_Manipulation;

public class leetcode_371 {
    public static void main(String[] args) {
        int a = 1000;
        int b = -1;
        System.out.println(Sum(a,b));

    }
    public static int Sum(int a,int b){
        int AorB = a^b;
        int Carry = a&b;
        while (Carry!=0) {
            Carry = Carry << 1;
            AorB = AorB ^ Carry;
            Carry = Carry & AorB;
        }
        return AorB;

//        if (a == 0 && b<0){
//            return b;
//        }
//        if (b == 0 && a<0){
//            return a;
//        }
//        int res = 0;
//        res = (int) Math.log10(Math.pow(Math.log(1), a)*Math.pow(Math.log(1),b));
//        return res;


    }
}
