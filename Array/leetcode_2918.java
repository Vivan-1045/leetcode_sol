package Array;

public class leetcode_2918 {
    public static void main(String[] args) {
        int[] arr = {3,2,0,1,0};
        int[] arr1 = {6,5,0};
        System.out.println(minEqualSum(arr,arr1));
    }

    //We need to increase the minimum sum to the maxSum of both the array
    // that's why need to return maxSum of both the array
    public static long minEqualSum(int[]arr1,int[]arr2){
        long sum1 =0 ,sum2 = 0;
        int zeroCount1 = 0,zeroCount2 =0;

        for (int num : arr1){
            sum1 += num == 0?1:num;
            zeroCount1 += num == 0?1:0;
        }
        for (int num : arr2){
            sum2 += num == 0?1:num;
            zeroCount2 += num == 0?1:0;
        }

        if ((sum1<sum2 && zeroCount1==0) || sum1>sum2 && zeroCount2==0){
            return -1;
        }
        return Math.max(sum1,sum2);
    }

}
