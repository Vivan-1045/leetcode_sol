package Maths;

public class leetcode_1922 {
    public static void main(String[] args) {
        System.out.println(goodNumber(50));
    }
    public static int goodNumber(long n){
        int MOD = 1000000007;
        long ans;

        long power1 = power(5,n/2,MOD);
        long power2 = power(4,n/2,MOD);


        if (n%2 !=0){
            power1 = (5*power1)%MOD;

        }

        //if n is even ans = 5^(n/2)*4^(n/2)
        //if n is odd ans = 5^(n/2+1)*4^(n/2)

        ans =  (power1 * power2)%MOD;
        return (int) ans;
    }
    public static long power(long base,long power,int MOD){
        long res =1;
        while (power>0){
            if ((power & 1)==1){
                res = (res *base)%MOD;
            }
            base = (base * base)%MOD;
            power /= 2;
        }
        return res;
    }
}
