package Array;

public class leetcode_1346 {
    public static void main(String[] args){
        int []arr = {7,1,14,11};
        System.out.println(isDouble(arr));
    }
    public static boolean isDouble(int []arr){
       int n = arr.length;
       for (int i=0;i<n-1;i++){
           for (int j = i+1;j<n;j++){
               if (arr[i] == 2*arr[j] || arr[j] == 2*arr[i]){
                   return true;
               }
           }
       }
       return false;
    }
}
