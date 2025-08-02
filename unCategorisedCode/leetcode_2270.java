package unCategorisedCode;

public class leetcode_2270 {
    public static void main(String[] args) {
        int [] arr = {2,3,1,0};
        System.out.println(ValidSplit(arr));
    }
    public static int ValidSplit(int[] arr){
        int n = arr.length;
        int Split = 0;
        long preSum[] = new long[n];
        preSum[0] = arr[0];
        for (int i =1;i<n;i++){
            preSum[i] = preSum[i-1]+arr[i];
        }
        for (int i = 0;i<n-1;i++){
            long left_sum = preSum[i];
            long right_sum = preSum[n-1]-left_sum;
            if (left_sum>=right_sum){
                Split++;
            }
        }
        return Split;
    }
}
