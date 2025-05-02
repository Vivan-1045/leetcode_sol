package Array;

import java.util.Arrays;

public class leetcode_189 {
    public static void main(String[] args) {
        int []arr= {1};
        int k = 0;
        System.out.println(Arrays.toString(rotatedArray1(arr,k)));
    }

    //getting tle = 37/38;
    public static int[] rotatedArray(int[]arr,int k){
        int n = arr.length;

        while (k>0){
            int ele = arr[n-1];
            for (int j = n-2;j>=0;j--){
                arr[j+1] = arr[j];
                if (j==0){
                    arr[j] = ele;
                }
            }
            k--;
        }
        return arr;
    }

    // TC : O(n), SC : O(1)
    public static int[] rotatedArray1(int[]arr, int k){
        int n = arr.length;
        if (k == 0){
            return arr;
        }

        k = k%n; //when k > n

        reverse(arr,0,n-1);
        reverse(arr,0,k-1);
        reverse(arr,k, n-1);
        return arr;
    }
    public static void reverse(int [] arr, int s , int e){
        while (s<=e){
            int ele = arr[e];
            arr[e] = arr[s];
            arr[s] = ele;
            s++;
            e--;
        }
    }
}
