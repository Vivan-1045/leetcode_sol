package DP;

import java.util.HashSet;
import java.util.Set;

public class leetcode_128 {
    public int longestConsecutive(int[] nums) {
        return maxlength(nums);
    }

    int maxlength(int[] arr){
        int n = arr.length;
        if (n == 0) return 0;

        Set<Integer> st = new HashSet<>();
        for (int ele : arr) {
            st.add(ele); // Insert all elements into the set
        }

        int maxlen = 0;

        for (int ele : st) {
            // Only try to build a sequence if 'ele' is the start of a sequence
            if (!st.contains(ele - 1)) {
                int curr = ele;
                int currMax = 1;

                // Count the length of the consecutive sequence
                while (st.contains(curr + 1)) {
                    curr++;
                    currMax++;
                }

                maxlen = Math.max(maxlen, currMax);
            }
        }

        return maxlen;
    }
}
