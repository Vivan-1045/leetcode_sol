package Sliding_window;

public class leetcode_413 {

    public static void main(String[] args) {
         int[] arr = {0};
        System.out.println(arithmaticSlices(arr));
    }
    public static int arithmaticSlices(int[] arr){
        int countArray=0;
        if (arr.length<3){
            return 0;
        }
        
        int j =0;
        for (int i =0;i<arr.length;i++){
            j = i+2;
            if (j>arr.length){
                return countArray;
            }
            while (j<arr.length){
               if (isArithmetic(arr,i,j)){
                   countArray++;
               }else{
                   break;
               }
               j++;
            }
        }
        return countArray;
    }
    public static boolean isArithmetic(int[] arr, int s, int e){
        for(int i = s;i<=e-2;i++){
            if(arr[i+1]-arr[i] != arr[i+2]-arr[i+1]){
                return false;
            }
        }
        return true;
    }
}
