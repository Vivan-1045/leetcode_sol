package Binary_Search;

public class leetcode_275 {
    public static void main(String[] args) {
        int[] arr = {11,15};
        System.out.println(Hindex(arr));
    }
    public static int Hindex(int[] arr){
        int s = 0;
        int n = arr.length;
        int e = n-1;

        int ans = 0;
        while(s<=e){
            int m = s + (e-s)/2;
            if(n-m<=arr[m]){
                ans = n-m;
                e = m-1;
            }else{
                s = m+1;
            }
        }
        return ans;
    }
}
