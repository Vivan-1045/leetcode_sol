package Maths;

import java.util.ArrayList;
import java.util.List;

public class leetcode_204 {
    public static void main(String[] args) {
        System.out.println(primeCount(499979));
    }
    public static int primeCount(int n){
        if (n<=1){
            return 0;
        }

       int res = n-2;
        for (int i = 2;i<n;i++){
            if (notPrime(i)){
                res--;
            }
        }
        return res;
    }
    public static boolean notPrime(int n){
        for (int i = 2;i<=Math.sqrt(n);i++){
            if (n%i==0){
                return true;
            }
        }
        return false;
    }
}
