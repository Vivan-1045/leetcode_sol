package Binary_Search;

import java.util.Arrays;

public class leetcode_3479 {
    public static void main(String[] args) {
        int[] arr = {4,2,5};
        int[] bas = {3,5,4};
        System.out.println(fruitleft(arr,bas));
    }
    public static int fruitleft(int []arr,int[]bas){
        Arrays.sort(bas);
        for(int num : arr){
            int idx  = isBasketAvailable(num,bas);
            bas[idx] = -1;
        }

        int count = 0;
        for(int num : bas){
            if(num>-1){
                count++;
            }
        }

        return count;
    }

    public static int isBasketAvailable(int ele,int[] arr){
        int idx  = arr.length-1;
        if(arr.length==1){
            if(ele<arr[0]){
                return 0;
            };
        }
        int s = 0;
        int e = arr.length-1;

        while(s<=e){
            int m = s + (e-s)/2;
            if(arr[m]>=ele){
                idx = m;
                e = m-1;
            }
            else {
                s = m+1;
            }
        }
        return idx;
    }
}
