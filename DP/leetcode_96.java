package DP;

import java.util.Arrays;

public class leetcode_96 {
    public int numTrees(int n) {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return uniqueTree(n);
    }
    int []dp;
    int uniqueTree(int n){
        if(n<=1){
            return 1;
        }

        if(dp[n] !=-1){
            return dp[n];
        }

        int res = 0;
        for(int i = 0;i<n;i++){
            res += uniqueTree(i)*uniqueTree(n-1-i);
        }

        return dp[n] = res;
    }
}
