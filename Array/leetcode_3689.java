package Array;

public class leetcode_3689 {
    public long maxTotalValue(int[] nums, int k) {
        return maxTotal(nums,k);
    }

    long maxTotal(int[] arr,int k){
        long ans = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int ele : arr){
            max = Math.max(max,ele);
            min = Math.min(min,ele);
        }

        long f = (long)(max-min);

        while(k-->0){
            ans += f;
        }

        return ans;
    }
}
