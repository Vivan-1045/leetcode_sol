package unCategorisedCode;

public class leetcode_29 {
    public static void main(String[] args) {
//        int dividend = 20;
//        int divisor = 2;
//        if(dividend == -2147483648){
//            System.out.println(Integer.MAX_VALUE);
//        }
        System.out.println(Divison(-2147483648, 2));
    }
    public static int Divison(int m , int n){
        if (Math.abs(m)==Math.abs(n)){
            return (m<0||n<0 || m<0 && n<0)? -1:1;
        }
        int p = 1;
        int k =0;
        int divend =Math.abs(m);
        while (p<divend){
            p += Math.abs(n);
            k++;
        }
        return (m<0||n<0 || m<0 && n<0)? -1*k:k;
    }
}
