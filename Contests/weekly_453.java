package Contests;

import java.util.ArrayDeque;
import java.util.Deque;

public class weekly_453 {
    public static void main(String[] args) {

    }

    //question 1.
    public static boolean isPossible(int[] nums, int k, int target) {
        int[] arr = nums.clone();
        int opr = 0;
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != target) {
                arr[i] *= -1;
                arr[i + 1] *= -1;
                opr++;
                if (opr > k) return false;
            }
        }

        return arr[n - 1] == target;
    }

    //question 2.
    static int MOD = 1_000_000_007;
    public static int partitionCount(int[] nums, int k) {
        int n = nums.length;

        long[] dp = new long[n + 1];
        long[] preSum = new long[n + 2];
        dp[0] = 1;
        preSum[1] = 1;

        Deque<Integer> max = new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>();

        int l = 0;

        for (int r = 0; r < n; r++) {
            while (!max.isEmpty() && nums[max.peekLast()] <= nums[r]) {
                max.pollLast();
            }
            max.addLast(r);

            while (!min.isEmpty() && nums[min.peekLast()] >= nums[r]) {
                min.pollLast();
            }
            min.addLast(r);

            while (nums[max.peekFirst()] - nums[min.peekFirst()] > k) {
                if (max.peekFirst() == l) max.pollFirst();
                if (min.peekFirst() == l) min.pollFirst();
                l++;
            }

            dp[r + 1] = (preSum[r + 1] - preSum[l] + MOD) % MOD;
            preSum[r + 2] = (preSum[r + 1] + dp[r + 1]) % MOD;
        }

        return (int) dp[n];
    }
}
