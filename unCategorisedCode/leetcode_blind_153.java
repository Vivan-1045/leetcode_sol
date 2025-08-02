package unCategorisedCode;

public class leetcode_blind_153 {
    public static void main(String[] args) {
        int []arr ={1,2};
        System.out.println(minElement(arr));
    }
    public static int minElement(int[]arr){
        if (arr.length==1){
            return arr[0];
        }
       int s = 0;
       int e = arr.length-1;
       while (s<=e){
           int m = s + (e-s)/2;
           //edge case 1
           if (m==0 && arr[m]<arr[m+1]){
               return arr[m];
           }
           //edge case 2
           if (m== arr.length-1 && arr[m]<arr[m-1]){
               return arr[m];
           }
           //Check if middle element is minimum
           if ((m>0 && m< arr.length) && arr[m]<arr[m-1] && arr[m]<arr[m+1]){
               return arr[m];
           } else if (arr[m]>arr[e]) {
               s = m+1;
           }else {
               e = m-1;
           }
       }
       return -1;
    }
}
