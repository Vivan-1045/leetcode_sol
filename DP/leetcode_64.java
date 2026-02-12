package DP;

import java.util.Arrays;

public class leetcode_64 {
    public static void main(String[] args) {
       int [][]arr = {{1,3,1},{1,5,1},{4,2,1}};
       dp = new int[arr.length+1][arr[0].length+1];

       for (int[]a:dp){
           Arrays.fill(a,-1);
       }

       int res = solve(arr,0,0);
       System.out.println(res);
    }

    static int[][]dp;

    static int solve(int[][]arr, int i, int j){
        if(i>=arr.length || j>=arr[0].length){
            return 0;
        }

        if (dp[i][j] != -1){
            return dp[i][j];
        }

        if(i==arr.length-1 && j==arr[0].length-1){
            return dp[i][j] = arr[i][j];
        }

        if(i==arr.length-1){
            return dp[i][j] = arr[i][j] + solve(arr,i,j+1);
        }
        if (j== arr[0].length-1){
            return dp[i][j] = arr[i][j] + solve(arr,i+1,j);
        }

        return dp[i][j] = arr[i][j] + Math.min(solve(arr,i+1,j),solve(arr,i,j+1));
    }
    int dp1[][];
    int solve1(int[][]arr){
        dp1 = new int[arr.length+1][arr[0].length+1];

        dp1[0][0] = arr[0][0];


        for(int j = 1;j<arr[0].length;j++){
            dp1[0][j] = dp1[0][j-1]+arr[0][j];
        }

        for(int i = 1;i<arr.length;i++){
            dp1[i][0] = dp1[i-1][0]+arr[i][0];
        }


        for(int i = 1;i<arr.length;i++){
            for(int j = 1;j<arr[0].length;j++){
                int min = Math.min(dp1[i-1][j],dp1[i][j-1]);
                dp1[i][j] = min+arr[i][j];
            }
        }

        return dp1[arr.length-1][arr[0].length-1];
    }


}
