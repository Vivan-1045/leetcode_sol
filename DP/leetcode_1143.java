package DP;

import java.util.Arrays;

public class leetcode_1143 {
    int[][]dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        dp = new int[n][m];

        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }

        return solve(text1,text2,n-1,m-1);
    }

    int solve(String s1, String s2,int i, int j){

        //Base case : if any one of length become zero just return 0
        if(i<0 || j<0){
            return 0;
        }

        //Check if pre-computed
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        //Core logic
        if(s1.charAt(i)==s2.charAt(j)){
            dp[i][j] = 1 + solve(s1,s2,i-1,j-1);
        }else{
            dp[i][j] = Math.max(solve(s1,s2,i-1,j),solve(s1,s2,i,j-1));
        }

        return dp[i][j];
    }
}
