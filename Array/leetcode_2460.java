package Array;

import java.util.Arrays;

public class leetcode_2460 {
    public static void main(String[] args) {
        int []arr= {1,2,2,1,1,0};
        System.out.println(Arrays.toString(arrayOpe(arr)));
    }
    public static int[] arrayOpe(int[] arr){
        for (int i = 0;i<arr.length-1;i++){
            if (arr[i] == arr[i+1]){
                arr[i] = 2*arr[i];
                arr[i+1] = 0;
            }else{
                continue;
            }
        }
        int nonZeroIdx = 0;
        for (int i = 0;i<arr.length;i++){
            if (arr[i]!=0){
                int temp = arr[i];
                arr[i] = arr[nonZeroIdx];
                arr[nonZeroIdx] = temp;
                nonZeroIdx++;
            }

        }
        return arr;
    }
}
