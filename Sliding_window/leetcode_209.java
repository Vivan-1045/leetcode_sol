package Sliding_window;

public class leetcode_209 {
    public static void main(String[] args) {
        int[] arr= {1,1,1,1,1,6};
        System.out.println(minSubArray(arr,7));
    }
    public static int minSubArray(int [] arr,int k){
        int n = arr.length;
        int ans = Integer.MAX_VALUE;

//        for (int i = 0;i<n;i++){
//            int sum = arr[i];
//
//            if (ans==1 || arr[i]>=k){
//                return 1;
//            }
//            for (int j = i;j<n;j++){
//                if (sum>=k){
//                    ans = Math.min(ans, j-i+1);
//                    break;
//                }
//                sum = j+1<n?sum + arr[j+1]:sum;
//            }
//        }

        int []cum = new int[n+1];
        for (int i = 1;i<=n;i++){
            cum[i] = arr[i-1]+cum[i-1];
        }

        if (cum[n]<k){
            return 0;
        }

        for (int i = 0;i<n;i++){
            for (int j = i+1;j<=n;j++) {
                if (cum[j] - cum[i] >= k) {
                    ans = Math.min(ans, j - i);
                    break;
                }
            }
        }
        return ans!=Integer.MAX_VALUE?ans:0;
    }
}
