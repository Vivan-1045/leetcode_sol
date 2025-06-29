package Contests;

import java.util.*;

public class weekly_456 {
    public static void main(String[] args) {
//        String s= "abbccccd";
//        System.out.println(getUniqueSegments(s));
        int[]arr= {1,2,3};
        System.out.println(miniXor(arr,2));
    }

    public static List<String> getUniqueSegments(String s) {
        Set<String> seen = new HashSet<>();
        List<String> result = new ArrayList<>();

        int i = 0;
        while (i < s.length()) {
            StringBuilder sb = new StringBuilder();
            boolean found = false;

            for (int j = i; j < s.length(); j++) {
                sb.append(s.charAt(j));
                String st = sb.toString();
                if (!seen.contains(st)) {
                    seen.add(st);
                    result.add(st);
                    i = j + 1;
                    found = true;
                    break;
                }
            }

            if (!found) i++;
        }

        return result;
    }

    static int[][] memo;
    static int n;
    static int K;
    static int[] prefixXor;

    public static int miniXor(int[] nums, int k) {
        n = nums.length;
        K = k;

        prefixXor = new int[n + 1];
        for (int i = 0; i < n; i++)
            prefixXor[i + 1] = prefixXor[i] ^ nums[i];

        int l = 0, r = (1 << 31) - 1;

        int ans = r;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            memo = new int[n + 1][K + 1];
            for (int i = 0; i <= n; i++)
                Arrays.fill(memo[i], -1);

            if (isPartition(0, k, mid)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isPartition(int s, int k, int limit) {
        if (k == 0) return s == n;
        if (n - s < k) return false;
        if (memo[s][k] != -1) return memo[s][k] == 1;

        for (int end = s; end <= n - k; end++) {
            int curXor = prefixXor[end + 1] ^ prefixXor[s];
            if (curXor <= limit) {
                if (isPartition(end + 1, k - 1, limit)) {
                    memo[s][k] = 1;
                    return true;
                }
            }
        }
        memo[s][k] = 0;
        return false;
    }

}
