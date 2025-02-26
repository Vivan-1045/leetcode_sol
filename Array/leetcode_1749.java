package Array;

public class leetcode_1749 {
    public static void main(String[] args) {
        int [] arr = {-3,-5,-3,-2,-6,3,10,-10,-8,-3,0,10,3,-5,8,7,-9,-9,5,-8};
        System.out.println(getAbsoluteSum(arr));
    }
    public static int getAbsoluteSum(int[] arr) {
        int sum = 0;
        int max = arr[0];
        int min = arr[0];

        // Kadane's algorithm to calculate the maximum subarray sum
        for (int k : arr) {
            sum += k;
            max = Math.max(max, sum);
            if (sum < 0) sum = 0;  // Reset sum when it becomes negative
        }

        sum = 0;
        // Kadane's algorithm to calculate the minimum subarray sum
        for (int j : arr) {
            sum += j;
            min = Math.min(min, sum);
            if (sum > 0) sum = 0;  // Reset sum when it becomes positive
        }

        // Return the maximum of max sum or the absolute min sum
        return Math.max(max, Math.abs(min));
    }

}
