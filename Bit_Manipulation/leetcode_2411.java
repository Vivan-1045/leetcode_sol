package Bit_Manipulation;

import java.util.Arrays;

public class leetcode_2411 {
    public static void main(String[] args) {
        int[] arr = {1,0,2,1,3};
        System.out.println(Arrays.toString(smallSubArrays(arr)));
    }
    public static int []smallSubArrays(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        int[] bitSeen = new int[32];

        Arrays.fill(bitSeen,-1);

        for(int i = n-1;i>=0;i--){
            for(int bit = 0;bit<32;bit++){
                if(((arr[i]>>bit)&1)!=0){
                    bitSeen[bit] = i;
                }
            }

            int j =i;
            for(int bit = 0;bit<32;bit++){
                if(bitSeen[bit] != -1){
                    j = Math.max(j,bitSeen[bit]);
                }
            }

            ans[i] = j-i+1;
        }
        return ans;
    }
}
