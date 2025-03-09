package Array;

import java.util.Arrays;

public class leetcode_3208 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 0};
        int k = 3;
        System.out.println(sliding(arr, k));
    }
    public static int sliding(int[]arr,int k){
        int n = arr.length;
        int count = 0;
        int [] updatedArray = Arrays.copyOf(arr,n+k-1);
        if (k - 1 >= 0) System.arraycopy(arr, 0, updatedArray, n + 0, k - 1);
        int j = 1;
        int i = 0;
        while (j<updatedArray.length){
            if (updatedArray[j-1]==updatedArray[j]){
                i=j;
                j++;
                continue;
            }
            if (j-i+1==k){
                count++;
                i++;
            }
            j++;
        }


        return count;
    }
}
