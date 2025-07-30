package Bit_Manipulation;

public class leetcode_2419 {
    public static void main(String[] args) {
        int[] arr = {1,2,9,9,9,3,2,2,9};
        System.out.println(longestSubArray(arr));
    }
    public static int longestSubArray(int[] arr){
        int n = arr.length;
        int maxEle = 0;
        int ans = 0;
        for (int num : arr){
            maxEle = Math.max(maxEle,num);
        }

        int count = 0;
        for (int j : arr) {
            if (j == maxEle) {
                count++;
                ans = Math.max(ans, count);
            } else if (j < maxEle) {
                count = 0;
            }
        }

        return ans;
    }
}
