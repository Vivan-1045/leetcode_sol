package Maths;

import java.util.Arrays;

public class leetcode_790 {
    static int []dp = new int[1001];
    static int MOD = 1000000007;

    //Formula used
    //f(n) = 2*f(n-1) + f(n-3)
    public static void main(String[] args) {
        int n = 4;
        System.out.println(dominoTromino(n));
    }

    //USing Memoization and recursion
    public static int dominoAndTromino(int n){
        Arrays.fill(dp,-1);
        return find(n);
    }
    public static int find(int n){
        if (n ==1 || n==2){
            return n;
        }
        if (dp[n] != -1){
            return dp[n];
        }
        if (n==3){
            return 5;
        }
        return dp[n] = (2*find(n-1)%MOD + find(n-3)%MOD)%MOD;
    }


    //Using bottom up approach
    public static int dominoTromino(int n){
        if (n ==1 || n==2){
            return n;
        }
        if (n==3){return 5;}
        int[]arr = new int[n+1];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 5;
        for (int i = 4;i<=n;i++){
            arr[i] = (2*arr[i-1]%MOD + arr[i-3]%MOD)%MOD;
        }
        return arr[n];
    }

}
