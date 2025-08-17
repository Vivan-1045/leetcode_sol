package Contests;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class weekly_463 {
    public static void main(String[] args) {

    }
    long maxPro(int[] price, int[] strategy, int k) {
        int n = price.length;
        long[] preSP = new long[n + 1];
        long[] preP = new long[n + 1];

        long startProfit = 0;

        for (int i = 0; i < n; i++) {
            long sp = (long) strategy[i] * price[i];
            preSP[i + 1] = preSP[i] + sp;
            preP[i + 1] = preP[i] + price[i];
            startProfit += sp;
        }

        long maxProfit = startProfit;

        for (int i = 0; i <= n - k; i++) {
            int mid = k / 2;

            long loss = preSP[i + mid] - preSP[i];

            long initialOld = preSP[i + k] - preSP[i + mid];
            long lastNew = preP[i + k] - preP[i + mid];

            long delta = -loss - initialOld + lastNew;
            maxProfit = Math.max(maxProfit, startProfit + delta);
        }

        return maxProfit;
    }

    public static long minSum(int[] nums, int k) {
        int n = nums.length;
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        long[] dp = new long[n + 1];
        Arrays.fill(dp, 0);

        Map<Long, Integer> modIndex = new HashMap<>();
        modIndex.put(0L, 0); 

        for (int i = 1; i <= n; i++) {
            long mod = preSum[i] % k;
            dp[i] = dp[i - 1]; 

            if (modIndex.containsKey(mod)) {
                int j = modIndex.get(mod);
                long subarraySum = preSum[i] - preSum[j];
                dp[i] = Math.max(dp[i], dp[j] + subarraySum);
            }

            modIndex.put(mod, i);
        }

        return preSum[n] - dp[n];
    }

}
