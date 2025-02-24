package DP;

import java.util.Arrays;

public class leetcode_377 {
    public static int[] memo;
    public static void main(String[] args) {
        int [] arr = {2,1,3};
        int amount = 39;
        memo = new int[amount+1];
        Arrays.fill(memo,-1);
        System.out.println(helper(arr,0,amount,0));
    }
    public static int helper(int[] arr , int s,int amount,int count){
        if (amount==0){
            return count +1;
        }

        if (memo[amount] != -1){
            return memo[amount];
        }
        int res = 0;
        for (s=0;s<arr.length;s++){
            if (amount-arr[s] >=0){
               res += helper(arr,s,amount-arr[s],count);
            }
        }

        memo[amount]= res;
        return res;
    }
}
