package Prefix_Sum;

public class leetcode_3346 {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        return maxFreq(nums,k,numOperations);
    }

    int maxFreq(int[] arr,int k , int numOpr){
        int n = 0;
        int ans = Integer.MIN_VALUE;

        for(int ele : arr){
            n = Math.max(ele,n);
        }

        int[] freq = new int[n+k+1];

        for(int i = 0;i<arr.length;i++){
            freq[arr[i]]++;
        }

        //Cummulative sum of frequency
        for(int i = 1;i<=n;i++){
            freq[i] += freq[i-1];
        }

        for(int i = 0;i<=n;i++){
            if(freq[i]==0){
                continue;
            }

            int l = Math.max(0,i-k);
            int r = Math.min(n,i+k);

            int totalCnt = freq[r] - (l>0?freq[l-1]:0);
            int targetCnt = freq[i] - (i>0?freq[i-1]:0);

            int conversionNeed  = totalCnt - targetCnt;

            int maxPossibleFreq = targetCnt + Math.min(numOpr,conversionNeed);
            ans = Math.max(ans,maxPossibleFreq);
        }

        return ans;
    }
}
