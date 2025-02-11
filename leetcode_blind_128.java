import java.util.Arrays;

public class leetcode_blind_128 {
    public static void main(String[] args) {
        int []arr ={100,-1,-3,-4,200,-2,-5,1,2,3};
        System.out.println(maxLength(arr));
    }
    public static int maxLength(int[]arr){
        Arrays.sort(arr);
        int n = arr.length;
        int [] arr1 = new int[arr.length];
        arr1[0] = 1;

        for (int i = 1; i < n; i++) {
            arr1[i] = arr[i]-arr[i-1];
        }
        int count = 0;
        int ans = Integer.MIN_VALUE;
        for (int num : arr1){
            if (num==1){
                count +=1;
            }
            else{
                ans = Math.max(ans,count);
                count = 0;
            }
        }
        return ans;
    }
}
