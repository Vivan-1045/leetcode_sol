package DP;

import java.util.Arrays;

public class leetcode_45 {
    static int []dp;
    public static void main(String[] args) {
        int[]arr = {5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};
        dp = new int[arr.length];
        Arrays.fill(dp,-1);
        System.out.println(minJumps(arr,0));
    }

    //Using DP
    public static int solve(int[] arr,int idx){
        if (idx>= arr.length-1){
            return 0;
        }
        if (dp[idx] != -1){
            return dp[idx];
        }

        int minJumps = Integer.MAX_VALUE;
        for (int i = 1;i<=arr[idx];i++){
           if (idx+i<arr.length){
               int jumps = solve(arr,idx+i);
               if (jumps != Integer.MAX_VALUE){
                   minJumps = Math.min(minJumps,jumps+1);
               }
           }
        }

        return dp[idx] = minJumps;
    }

    //Using Greedy
    public static int minJumps(int []arr,int maxJumps){
        int jump = 0;
        int left = 0,right =0,maxjumps = 0;
        while (right<arr.length-1){
            for (int i = left;i<=right;i++){
                maxjumps = Math.max(i+arr[i],maxJumps);
            }
            jump++;
            left = right+1;
            right = maxjumps;
        }
        return jump;
    }
}
