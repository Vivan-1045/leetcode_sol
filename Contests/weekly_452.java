package Contests;
import java.util.*;

public class weekly_452 {
    static final int MAX = 100_005;
    static boolean[] isPrime = new boolean[MAX];
    public static void main(String[] args) {

    }
    public static boolean seen(int[] nums, long target) {
        int n = nums.length;
        int total = 1 << n;

        for (int mask = 1; mask < total - 1; mask++) {
            List<Integer> subsetA = new ArrayList<>();
            List<Integer> subsetB = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subsetA.add(nums[i]);
                } else {
                    subsetB.add(nums[i]);
                }
            }

            long prodA = getProduct(subsetA);
            long prodB = getProduct(subsetB);

            if (prodA == target && prodB == target) {
                return true;
            }
        }

        return false;
    }

    private static long getProduct(List<Integer> list) {
        long prod = 1;
        for (int num : list) {
            prod *= num;
            if (prod > 1_000_000_000_000_000L) {
                return -1;
            }
        }
        return prod;
    }


    //Qestion 2 TLE
    public int[] maximumCount(int[] nums, int[][] queries) {
        sieve();

        int n = nums.length;
        int[] arr = Arrays.copyOf(nums, n);
        int[] res = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int idx = queries[q][0];
            int val = queries[q][1];

            arr[idx] = val;

            int[] prefix = new int[n];
            BitSet seenPrefix = new BitSet(MAX);
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (isPrime[arr[i]] && !seenPrefix.get(arr[i])) {
                    seenPrefix.set(arr[i]);
                    count++;
                }
                prefix[i] = count;
            }

            int[] suffix = new int[n];
            BitSet seenSuffix = new BitSet(MAX);
            count = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (isPrime[arr[i]] && !seenSuffix.get(arr[i])) {
                    seenSuffix.set(arr[i]);
                    count++;
                }
                suffix[i] = count;
            }

            int max = 0;
            for (int i = 0; i < n - 1; i++) {
                max = Math.max(max, prefix[i] + suffix[i + 1]);
            }
            res[q] = max;
        }

        return res;
    }

    void sieve() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i < MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

}
