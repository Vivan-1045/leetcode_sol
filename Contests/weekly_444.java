package Contests;

public class weekly_444 {
    public static void main(String[] args) {
        int arr[] = {5,2,3,1};
        System.out.println(sortedArray(arr));
    }
    public static int sortedArray(int[] nums) {
        int operations = 0;

        while (!isSorted(nums)) {
            int minSum = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int i = 0; i < nums.length - 1; i++) {
                int sum = nums[i] + nums[i + 1];
                if (sum < minSum) {
                    minSum = sum;
                    minIndex = i;
                }
            }

            nums[minIndex] = minSum;

            for (int i = minIndex + 1; i < nums.length - 1; i++) {
                nums[i] = nums[i + 1];
            }

            nums = java.util.Arrays.copyOf(nums, nums.length - 1);

            operations++;
        }

        return operations;
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

}
