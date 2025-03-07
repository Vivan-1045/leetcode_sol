package Maths;

import java.util.Arrays;

public class leetcode_2523 {
    public static void main(String[] args) {
        int n1 = 10;
        int n2 = 19;

        System.out.println(Arrays.toString(getPrimePair(n1,n2)));

    }
    public static int[] getPrimePair(int n1, int n2) {
        int a = -1, b = -1;
        int c = -1, d = -1;
        int res = Integer.MAX_VALUE;

        for (int i = n1; i <= n2; i++) {
            if (isPrime(i)) {
                if (a == -1) {
                    a = i;
                } else {
                    b = i;
                    int diff = b - a;
                    if (diff < res) {
                        res = diff;
                        c = a;
                        d = b;
                    } else if (diff == res && a < c) {
                        c = a;
                        d = b;
                    }
                    a = b;
                    b = -1;
                }
            }
        }

        return (c != -1 && d != -1)?new int[]{c,d}: new int[]{-1,-1};
    }


    public static boolean isPrime(int n ){
        if(n<=1){
            return false;
        }
        if (n==2) return true;
        //To remove all the even numbers
        if (n%2==0) return false;
        for (int i  = 3;i<=Math.sqrt(n);i+=2){
            if (n%i==0){
                return false;
            }
        }
        return true;
    }
}
