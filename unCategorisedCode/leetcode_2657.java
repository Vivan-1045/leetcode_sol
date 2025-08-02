package unCategorisedCode;

import java.util.Arrays;
public class leetcode_2657 {
    public static void main(String[] args) {
        int[] A = {2,3,1};
        int[] B = {3,1,2};
        System.out.println(Arrays.toString(ans(A,B)));
    }
    public static int[] ans(int[]A,int[]B){

        int[] ans = new int[A.length];
        for (int i = 0; i <= A.length-1; i++) {
            int count =0;
            for (int j = 0; j <=i; j++) {
               for (int m = 0 ;m<=i;m++){
                   if (A[m]==B[j]){
                       count += 1;

                   }
               }
            }
            ans[i] = count;
        }
        return ans;
    }
}
