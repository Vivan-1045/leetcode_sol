package Contests;

import java.util.Arrays;
import java.util.Comparator;

public class biweekly_163 {
    public static void main(String[] args) {
       int [] arr= {-3,2,-1,4};
        System.out.println(perfectPair(arr));
    }

    public static long perfectPair(int[] nums) {
        int n = nums.length;

        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }

        Arrays.sort(idx, Comparator.comparingInt(i -> Math.abs(nums[i])));

        long count = 0;
        int r = 1;

        for (int l = 0; l < n - 1; l++) {
            int a = nums[idx[l]];
            int absA = Math.abs(a);

            while (r < n) {
                int b = nums[idx[r]];
                int absB = Math.abs(b);

                int diff = Math.abs(a - b);
                int sum = Math.abs(a + b);

                int minDiff = Math.min(diff, sum);
                int maxDiff = Math.max(diff, sum);
                int minAbs = Math.min(absA, absB);
                int maxAbs = Math.max(absA, absB);

                if (minDiff <= minAbs && maxDiff >= maxAbs) {
                    r++;
                } else {
                    break;
                }
            }

            count += (r - l - 1);

            if (r == l + 1) {
                r++;
            }
        }

        return count;
    }


}
