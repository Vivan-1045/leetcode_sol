package Binary_Search;

public class leetcode_2226 {
    public static void main(String[] args) {
        int[] arr = {5,8,6};
        long k = 3;
        System.out.println(maxiCandies(arr,k));
    }
    public static int maxiCandies(int[] arr,long k){

        int l =1;
        int r = 0;
        int count = 0;
        int totalCandies = 0;
        for (int num : arr){
            totalCandies += num;
            r = Math.max(r,num);
        }
        if (totalCandies<k){
            return 0;
        }

        while (l<=r){
            int m = l + (r-l)/2;
            if(canAssign(m,arr,k)){
                count = m;
                l=m+1;
            }else {
                r= m-1;
            }
        }
        return count;
    }
    public static boolean canAssign(int mid , int[] arr, long k){

        for (int j : arr) {
            k -= j / mid;
            if (k <= 0) {
                return true;
            }
        }
        return k<=0;
    }
}
