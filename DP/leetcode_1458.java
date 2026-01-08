package DP;

import java.util.Arrays;

public class leetcode_1458 {
    int [][]dp;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        n = nums1.length;
        m = nums2.length;
        dp = new int[n][m];

        for(int []a: dp){
            Arrays.fill(a,-1000000000);
        }

        return solve(nums1,nums2,0,0);
    }

    int n = 0;
    int m = 0;

    int solve(int[]arr1, int[]arr2,int i, int j){
        if(i==n||j==m){
            return -1000000000;
        }

        if(dp[i][j] != -1000000000){
            return dp[i][j];
        }

        int val = arr1[i]*arr2[j];
        int take_both = (arr1[i]*arr2[j])+solve(arr1,arr2,i+1,j+1);
        int take_i = solve(arr1, arr2, i,j+1);
        int take_j = solve(arr1,arr2,i+1,j);

        return dp[i][j] = Math.max(Math.max(val,take_both),Math.max(take_i,take_j));
    }
}
