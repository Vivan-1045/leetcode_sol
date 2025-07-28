package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class leetcode_907 {
    public static void main(String[] args) {
        int[] arr = {3,1,2,4};
        System.out.println(minSumOfSubArray1(arr));
    }

    //Brute force
    public static int minSumOfSubArray(int[] arr){
        int MOD = 1000000007;
        int minSum = 0;
        int n = arr.length;

        for(int i = 0;i<n;i++){
            int currMin = arr[i];
            for(int j = i;j<n;j++){
                currMin = Math.min(currMin,arr[j]);
                minSum = (minSum%MOD + currMin)%MOD;
            }
        }

        return minSum;
    }

    //Optimal
    public static int minSumOfSubArray1(int[] arr) {
        int MOD = 1_000_000_007;
        int n = arr.length;
        long result = 0;

        int[] prevLess = new int[n];
        int[] nextLess = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            prevLess[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nextLess[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            long left = i - prevLess[i];
            long right = nextLess[i] - i;
            result = (result + arr[i] * left * right) % MOD;
        }

        return (int) result;
    }

}
