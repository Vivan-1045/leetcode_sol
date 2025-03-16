package Contests;

import java.util.*;

public class weekly_441 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int[] nums = {0,1,2,3};
        System.out.println((maxSubarray(arr,nums)));
    }
    public static List<Integer> maxSubarray(int[] nums, int [] queries){
        int n = nums.length;
        List<Integer> result = new ArrayList<>();

        Map<Integer, List<Integer>> valueToIndices = new HashMap<>();

        for (int i = 0; i < n; i++) {
            valueToIndices.putIfAbsent(nums[i], new ArrayList<>());
            valueToIndices.get(nums[i]).add(i);
        }

        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        for (Map.Entry<Integer, List<Integer>> entry : valueToIndices.entrySet()) {
            List<Integer> indices = entry.getValue();

            if (indices.size() <= 1) continue;  // If a value appears only once, skip

            for (int i = 0; i < indices.size(); i++) {
                int currIdx = indices.get(i);
                int nextIdx = indices.get((i + 1) % indices.size());

                int dist = Math.min(Math.abs(nextIdx - currIdx), n - Math.abs(nextIdx - currIdx));

                minDist[currIdx] = Math.min(minDist[currIdx], dist);
                minDist[nextIdx] = Math.min(minDist[nextIdx], dist);
            }
        }

        for (int query : queries) {
            int value = nums[query];
            if (valueToIndices.get(value).size() <= 1) {
                result.add(-1);
            } else {
                result.add(minDist[query] == Integer.MAX_VALUE ? -1 : minDist[query]);
            }
        }

        return result;
    }
}
