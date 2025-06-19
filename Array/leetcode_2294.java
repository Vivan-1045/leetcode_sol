package Array;

import java.util.Arrays;

public class leetcode_2294 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(maxOpr(arr,1));
    }
    public static int maxOpr(int[] arr,int k){
        int count = 1;
        int n = arr.length;

        Arrays.sort(arr);
        int minVal =  arr[0];
        for (int j : arr) {
            if (Math.abs(j - minVal) > k) {
                count++;
                minVal = j;
            }
        }
        return count;
    }
}
