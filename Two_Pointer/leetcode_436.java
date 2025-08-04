package Two_Pointer;

import java.util.Arrays;

public class leetcode_436 {
    public static void main(String[] args) {
        int[][] interval = {{2,3},{2,4},{8,2}};
        System.out.println(Arrays.toString(rightInterval(interval)));
    }
    public static int[] rightInterval(int[][] intV){

        int n = intV.length;
        int [] ans = new int[n];

        for(int i = 0;i<n;i++){
            int e = intV[i][1];
            int minIdx = -1;
            int currIntV = Integer.MAX_VALUE;

            for(int j = 0;j<n;j++){
                int s = intV[j][0];
                if(s>=e){
                    currIntV = Math.min(currIntV,s);
                }
            }


            for(int k = 0;k<n;k++){
                if(intV[k][0]==currIntV){
                    minIdx = k;
                }
            }

            ans[i]= minIdx;

        }

        return ans;
    }
}
