package DP;

import java.util.ArrayList;
import java.util.List;

public class leetcode_494 {
    public int findTargetSumWays(int[] nums, int target) {
        return targetSumWay(nums,target);
    }

    int targetSumWay(int[] nums,int tar){

        if(nums.length==1){
            int cnt = 0;
            if(nums[0]==tar)cnt++;
            if(-nums[0]==tar)cnt++;
            return cnt;
        }


        List<Integer> list = new ArrayList<>();
        int sum = 0;
        int zeroCount = 0;
        for(int ele : nums){
            sum+=ele;
            if(ele==0){
                zeroCount++;
            }else{
                list.add(ele);
            }
        }

        if((sum-tar)<0 || (sum-tar)%2!=0){
            return 0;
        }

        int[]nonZero = new int[list.size()];
        for(int i =0;i<list.size();i++){
            nonZero[i] = list.get(i);
        }

        int targetSum = (sum-tar)/2;

        return (int)(totalCount(nonZero,targetSum)*Math.pow(2,zeroCount));
    }

    int totalCount(int[] arr, int tar){
        int n = arr.length;
        int dp[][] = new int[n+1][tar+1];

        for(int i = 0;i<=n;i++){
            dp[i][0] = 1;
        }

        for(int i = 1;i<=n;i++){
            for(int j = 0;j<=tar;j++){
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][tar];
    }
}
