package Array;

import java.util.Arrays;

public class leetcode_2966 {
    public static void main(String[] args) {
        int [] arr = {1,3,4,8,7,9,3,5,1};
        System.out.println(Arrays.deepToString(dividedArray(arr,2)));
    }
    public static int[][] dividedArray(int[] arr,int k){
        int n = arr.length;
        int[][] ans = new int[n/3][3];
        Arrays.sort(arr);
        int j =0;
        for (int i = 0;i<n-2;i+=3){
            if (Math.abs(arr[i]-arr[i+1])<=k && Math.abs(arr[i]-arr[i+2])<=k && Math.abs(arr[i+1]-arr[i+2])<=k){
                int []arr1= new int[3];
                arr1[0]=arr[i];
                arr1[1]=arr[i+1];
                arr1[2] = arr[i+2];

                if (j<n/3) {
                    ans[j] = arr1;
                    j++;
                }

            }else{
                return new int[][]{};
            }
        }
        return ans;
    }
}
