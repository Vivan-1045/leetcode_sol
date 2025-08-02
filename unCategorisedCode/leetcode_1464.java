package unCategorisedCode;

import java.util.Arrays;

public class leetcode_1464 {
    public static void main(String[] args) {
        int[]nums = {3,4,5,2};
        int ans = MaxProduct(nums);
        System.out.println(ans);
    }
    public static int MaxProduct(int[] arr){
        int max = 1;
        Arrays.sort(arr);
        int n = arr.length-1;
            max = (arr[n]-1)*(arr[n-1]-1);

        return max;
    }
}
