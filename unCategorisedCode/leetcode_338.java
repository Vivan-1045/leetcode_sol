package unCategorisedCode;

import java.util.Arrays;

public class leetcode_338 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(Arrays.toString(bitArray(n)));
    }
    public static int[] bitArray(int n){
        int [] ans = new int[n+1];
        for (int i = 0;i<=n;i++){
//            int count = 0;
//            int m = i;
//            while (m>0){
//                if ((m&1)==1){
//                    count++;
//                }
//                m = m>>1;
//            }
            //Optimized way
            ans[i] = ans[i>>1] + (i&1);
        }
        return ans;
    }
}
