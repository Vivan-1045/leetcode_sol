package Bit_Manipulation;

import java.util.Arrays;

public class leetcode_137 {
    public static void main(String[] args) {
        int[] arr = {2,2,3,2};
//        System.out.println(uniqueNumber(arr));
        System.out.println(unique(arr));
    }
    public static int uniqueNumber(int[] arr){
        if (arr.length<3){
            return arr[0];
        }
        Arrays.sort(arr);
        int j = 0;
        for (int i = 0;i<arr.length;i++){
            j = i+2;
            if (j>arr.length){
                return arr[i];
            }



            if (arr[i] != arr[j]){
                return arr[i];
            }
            i=j;
        }
        return 0;
    }

    //Using bit Modulo counting Standard way
    public static int unique(int [] arr){
        int ans = 0;
        for (int i = 0; i<=31;i++){
            int oneCount = 0;
            for (int num : arr){
                if ((num&(1<<i)) !=0) {
                    oneCount++;
                }
            }
            if (oneCount%3 ==1){
                ans = ans | 1<<i;
            }
        }
        return ans;
    }
}
