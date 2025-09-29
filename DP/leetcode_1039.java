package DP;

import java.util.Arrays;

public class leetcode_1039 {
    static int dp[][] = new int[52][52];
    public int minScoreTriangulation(int[] values) {
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        return solve(values,0,values.length-1);
    }

    int solve(int [] arr, int i, int j){

        if(j-i+1<3){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int res = Integer.MAX_VALUE;
        for(int k = i+1;k<j;k++){
            int wt = arr[i]*arr[j]*arr[k] + solve(arr,i,k)+ solve(arr,k,j);

            res = Math.min(res,wt);

        }

        return dp[i][j] = res;
    }
}
