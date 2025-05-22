package DP;

import java.util.Arrays;

public class leetcode_198 {
    static int []dp;
    public static void main(String[] args) {
        int[] arr = {188,67,205,94,205,169,241,202,144,240};
        dp = new int[arr.length];
        Arrays.fill(dp,-1);
        System.out.println(solve(arr,0));
    }

    public static int solve(int[] num,int i){
        if (i>=num.length){
            return 0;
        }

        //if result is calculated already then return it
        if (dp[i] != -1){
            return dp[i];
        }

        int moneyAdded = num[i] + solve(num,i+2);
        int skippedMoney = solve(num,i+1);

        //otherwise store the result in dp[i]
        return dp[i] = Math.max(moneyAdded,skippedMoney);
    }
}