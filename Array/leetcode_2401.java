package Array;



public class leetcode_2401 {
    public static void main(String[] args) {
        int[] arr= {1,3,8,48,10};
        System.out.println(lengthOfNice(arr));
    }
    public static int niceSubArray(int[]arr){
        int res = 1;
        int n = arr.length;
        for (int i = 0;i<n;i++){
            for (int j = i;j<n;j++){
               if (isNice(arr,i,j)){
                   res = Math.max(res,j-i+1);
               }else{
                   break;
               }
            }
        }
        return res;
    }
    public static boolean isNice(int[] arr, int s,int e){
        int n = arr.length;
        int usedbit= 0;
        if (e-s+1<=1) {
            return true;
        }
        for (int i = s;i<=e;i++){
            if ((usedbit & arr[i])!=0){
                usedbit = 0;
                return false;
            }
            usedbit |= arr[i];
        }
        return usedbit!=0;
    }

    public static int lengthOfNice(int[] arr){
        int res = 1;
        int n = arr.length;
        for (int i = 0;i<n;i++){
            int bitMask = 0;
            for (int j = i;j<n;j++){
              if ((arr[j]&bitMask) ==0){
                  bitMask |= arr[j];
              }else{
                  break;
              }
              res = Math.max(j-i+1,res);
            }

        }
        return res;
    }
}
