package Binary_Search;


public class leetcode_2560 {
    public static void main(String[] args) {
        int []arr = {2,7,9,3,1};
        int k = 2;
        System.out.println(minCapability(arr,k));
    }

    public static int minCapability(int[] arr, int k){
       int l =1;
       int r = 0;
       int res = 0;
       for (int num : arr){
           l = Math.min(l,num);
           r = Math.max(r,num);
       }

       while (l<=r){
           int m = l+(r-l)/2;
           if (isCapable(arr,m,k)){
              res = m;
              r = m-1;
           }else{
               l = m+1;
           }
       }
       return res;
    }

    public static boolean isCapable(int[] arr, int m, int k) {
        int n = arr.length;
        int house = 0;
        for (int i = 0;i<n;i++){
            if (arr[i]<=m){
               house++;
               i++;
            }
        }
        return house>=k;
    }
}
