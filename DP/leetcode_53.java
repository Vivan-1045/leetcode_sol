package DP;

public class leetcode_53 {
    public int maxSubArray(int[] nums) {
        return maxSumSub(nums);
    }

    int maxSumSub(int[] arr){
        int n = arr.length;
        int maxSum = 0;

        if(n==1){
            return arr[0];
        }

        int currSum = 0;
        int negMax = Integer.MIN_VALUE;

        //To handle the all negative element
        for(int i = 0; i<arr.length;i++){
            if(arr[i]<0){
                negMax = Math.max(negMax,arr[i]);
                if(i==arr.length-1){
                    return negMax;
                }
            }else{
                break;
            }
        }

        //Kadan's algo
        for(int ele : arr){
            currSum += ele;

            if(currSum<0){
                currSum = 0;
            }

            if(currSum>maxSum){
                maxSum = currSum;
            }
        }

        return maxSum;
    }
}
