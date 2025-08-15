package Algos;

import java.util.Arrays;

public class Radix_sort {
    public static void main(String[] args) {
        int[] arr = {1,1111,1111};
        System.out.println("Original array : "+ Arrays.toString(arr));
        radixSort(arr);
        System.out.println("Output array : " + Arrays.toString(arr));
    }

    public static void radixSort(int[] arr){
        int max = Arrays.stream(arr).max().getAsInt();

        for(int exp = 1;max / exp >0 ; exp*=10){
            countDigitSort(arr,exp);
        }
    }

    public static void countDigitSort(int[] arr, int exp){
        int n = arr.length;
        int []count = new int[10];
        int []output = new int[n];

        //Count the digit frequency
        for (int i = 0;i<n;i++){
            int digit = (arr[i]/exp)%10;
            count[digit]++;
        }

        //updated count array
        for(int i = 1;i<10;i++){
            count[i] += count[i-1];
        }

        //Output array
        for(int i = n-1;i>=0;i--){
            int digit = (arr[i]/exp)%10;
            output[count[digit]-1] = arr[i];
            count[digit]--;
        }

        //Copy output array to original Array
        for (int i = 0;i<n;i++){
            arr[i] = output[i];
        }
    }
}
