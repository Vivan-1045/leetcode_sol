package Array;

import java.util.Arrays;

public class leetcode_75 {
    public static void main(String[] args) {
        int [] arr = {2,0,2,1,1,0};
        coloredArray(arr);
    }
    public static void coloredArray(int[] arr){
        int zeroCount= 0,oneCount = 0,twoCount = 0;
        int [] ans = new int[arr.length];
        for (int j : arr) {
            if (j == 0) {
                zeroCount++;
            } else if (j == 1) {
                oneCount++;
            } else {
                twoCount++;
            }
        }
        int n = arr.length;
        int i = 0;
        while (i<=n){
            while (zeroCount !=0){
                ans[i] = 0;
                i++;
                zeroCount--;
            }
            while (oneCount != 0){
                ans[i] =1;
                i++;
                oneCount--;
            }
            while (twoCount != 0){
                ans[i] = 2;
                i++;
                twoCount--;
            }
            i++;
        }
        arr = Arrays.copyOf(ans,ans.length);
        for(int element : arr){
            System.out.print(element);
        }
    }
}
