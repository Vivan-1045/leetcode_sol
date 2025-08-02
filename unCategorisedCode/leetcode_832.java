package unCategorisedCode;

import java.util.Arrays;

public class leetcode_832 {
    public static void main(String[] args) {
        int [][] a = {{1,1,0},{1,0,1},{0,0,0}};
        int [][] b = FlipImage(a);
        System.out.println(Arrays.deepToString(b));
    }
    public static int[][] FlipImage(int[][] a){
        for(int[] a1: a){
            for (int i= 0;i<(a[0].length+1)/2;i++){
                int temp = a1[i]^1;
                a1[i] = a1[a[0].length-i-1]^1;
                a1[a[0].length-i-1] = temp;

            }
        }
        return a;
    }
}
