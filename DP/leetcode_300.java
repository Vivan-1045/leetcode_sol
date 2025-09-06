package DP;

public class leetcode_300 {
    int dp[][];

    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length][nums.length];
        return solve(0,-1,nums);
    }

    int solve(int idx, int preIdx,int[] arr){
        if(idx>=arr.length){
            return 0;
        }

        if(dp[idx][preIdx+1] != 0){
            return dp[idx][preIdx+1];
        }

        int add = 0,skip=0;
        if(preIdx ==-1 || arr[preIdx]<arr[idx]){
            add = 1 + solve(idx+1,idx,arr);
        }

        skip = solve(idx+1,preIdx,arr);

        return dp[idx][preIdx+1] = Math.max(skip,add);
    }
}
