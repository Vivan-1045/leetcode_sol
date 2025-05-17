package Matrix;

import java.util.Arrays;

public class leetcode_48 {
    public static void main(String[] args) {
        int[][] arr = {{1}};
        System.out.println(Arrays.deepToString(rotateImage(arr)));
    }
    public static int[][] rotateImage(int [][] arr){
        int n = arr.length;

        for (int i = 0;i<n;i++){
            for (int j = i;j<n;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        for (int []row : arr){
            reverse(row);
        }

        return arr;
    }
    public static void reverse(int []arr){
        int e = arr.length-1;
        for (int i = 0;i<arr.length;i++){
            if (e>i) {
                int temp = arr[e];
                arr[e] = arr[i];
                arr[i] = temp;
                e--;
            }
        }
    }
}
