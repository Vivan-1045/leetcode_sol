package Array;

import java.util.Arrays;

public class leetcode_462 {
    public static void main(String[] args) {
        int []arr = {1,2,3};
        System.out.println(minOpr(arr));
    }
    public static int minOpr(int[] arr){
        Arrays.sort(arr);
        int m = arr.length/2;
        int mediun = arr[m];
        int ans =0;

        for(int ele : arr){
            ans += Math.abs(mediun-ele);
        }
        return ans;
    }
}
