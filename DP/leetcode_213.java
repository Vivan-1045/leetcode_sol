package DP;

import java.util.Arrays;

public class leetcode_213 {
    static int[] dp;
    public static void main(String[] args) {
        int []nums= {200,3,140,20,10};
        dp = new int[nums.length];
        Arrays.fill(dp,-1);

        if (nums.length==1){
            System.out.println(nums[0]);
            return;
        }
        if (nums.length==2){
            System.out.println(Math.max(nums[0],nums[1]));
            return;
        }

        //Since we can't rob House[0]--House[n-1] because they are adjacent since all houses are in circular path.
        //That's why robbed money as robbed in house robber 1 from House[0]--House[n-2] and House[1]--House[n-1]

        int an1 = maxRobbedMoney(nums,1,nums.length-1);
        Arrays.fill(dp,-1);
        int an2 = maxRobbedMoney(nums,0,nums.length-2);

        System.out.println(Math.max(an1,an2));
    }

    //Below method is same as house robber 1
    public static int maxRobbedMoney(int[] num,int i,int len){
        if (i>len){
            return 0;
        }

        if (dp[i]!= -1){
            return dp[i];
        }

        int steal = num[i]+maxRobbedMoney(num,i+2,len);
        int skipHouse = maxRobbedMoney(num,i+1,len);

        return dp[i] = Math.max(steal,skipHouse);
    }
}
