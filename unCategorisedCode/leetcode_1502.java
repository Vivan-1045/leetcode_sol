package unCategorisedCode;

import java.util.Arrays;

public class leetcode_1502 {
    public static void main(String[] args) {
        int[] arr = {1,2,4};
        Arrays.sort(arr);
        int Sub = arr[1]-arr[0];
        int n = arr.length-1;
        for(int i =1; i<n;i++){
            if(arr[i+1]-arr[i] != Sub){
                System.out.println(false);
            }
        }
        System.out.println(true);
    }
}
