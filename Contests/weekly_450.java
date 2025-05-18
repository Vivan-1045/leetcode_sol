package Contests;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class weekly_450 {
    public static void main(String[] args) {
        int [] arr = {100};
        System.out.println(minSwap(arr));;
    }
    public static int sumOfDigi(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static int smallidx(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (sumOfDigi(nums[i]) == i) {
                return i;
            }
        }
        return -1;
    }

    public static int digitSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static int minSwap(int[] nums) {
        int n = nums.length;

        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = i;
            arr[i][1] = nums[i];
            arr[i][2] = digitSum(nums[i]);
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[2] != b[2]) {
                return a[2] - b[2];
            }
            return a[1] - b[1];
        });

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, arr[i][0]);
        }

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || map.get(i) == i) continue;

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = map.get(j);
                cycleSize++;
            }

            if (cycleSize > 1) {
                swaps += (cycleSize - 1);
            }
        }

        return swaps;
    }
}
