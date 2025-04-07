package DP;

import java.util.ArrayList;
import java.util.Arrays;

public class leetcode_416 {
    static int [][]dp = new int[201][200001];
    public static void main(String[] args) {
       int [] arr = {1,2,3,5};
        System.out.println(isPossible(arr));
    }
    public static boolean isPossible(int[] nums){
        ArrayList<Integer> list = new ArrayList<>();
        int Sum = 0;
        for(int i = 0;i<nums.length;i++){
            list.add(nums[i]);
        }

        for(int ele: nums){
            Sum += ele;
        }

        if (Sum%2 != 0){
            return false;
        }

        for (int[] arr : dp){
            Arrays.fill(arr,-1);
        }

        int half = Sum/2;

        return solve(list,0,half);
    }
    public static boolean solve(ArrayList<Integer> list,int i,int half){
        if (half==0){
            return true;
        }

        if (i>= list.size()){
            return false;
        }

        if (dp[i][half] !=-1){
            return dp[i][half] == 1;
        }

        boolean take = false;
        if (list.get(i)<=half){
            take = solve(list,i+1,half-list.get(i));
        }

        boolean not_take = solve(list,i+1,half);

        dp[i][half] = (take||not_take)?1:0;
        return take || not_take;
    }
}
