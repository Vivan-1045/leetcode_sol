public class leetcode_1800 {
    public static void main(String[] args) {
        int[] arr = {5,5,6,6,6,9,1,2};
        System.out.println(maxSum(arr));
    }
    public static int maxSum(int[]arr){
        if (arr.length==1){
            return arr[0];
        }
        int sum = arr[0];
        int ans = Integer.MIN_VALUE;
        for (int i =1;i< arr.length;i++){
            if (arr[i]>arr[i-1]){
                sum += arr[i];
            }
            ans = Math.max(ans,sum);
            if(arr[i]<=arr[i-1]){
                sum = 0;
                sum += arr[i];
            }

        }
        return ans;
    }
}
