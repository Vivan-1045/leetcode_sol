package unCategorisedCode;

import java.util.Arrays;

public class leetcode_1491 {
    public static void main(String[] args) {
        int[] nums = {4000,3000,1000,2000};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int sum= 0;
        int ag = 0;
        for (int i= 1; i<nums.length-1;i++){
            sum += nums[i];
            ag = (sum)/i;
        }
        System.out.println(sum);
        System.out.println(ag);
    }
}
