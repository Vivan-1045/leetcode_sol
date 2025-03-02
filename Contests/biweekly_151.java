package Contests;

import java.util.*;

public class biweekly_151 {
    public static void main(String[] args) {
        int[] arr = {1,5,1,4,2};
        int [] nums= {6,2,8,4};
        System.out.println(cost(nums));
//        System.out.println(Arrays.toString(transArray(arr)));
    }
    //First question
    public static int[] transArray(int[] arr){
        for (int i = 0;i<arr.length;i++){
            if (arr[i]%2 !=0){
                arr[i] = 1;
            }
            else {
                arr[i] = 0;
            }
        }
        Arrays.sort(arr);
        return arr;
    }

    //2nd question
    public static int cost(int[] nums){
        int n = nums.length;
        int cost = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while (n > 0) {
            pq.clear();

            for (int i = 0; i < Math.min(3, n); i++) {
                pq.offer(nums[i]);
            }

            int first = pq.poll();
            int second = pq.poll();
            cost += Math.max(first, second);

            for (int i = 2; i < n; i++) {
                nums[i - 2] = nums[i];
            }

            n -= 2;

            if (n <= 2) {
                cost += nums[0];
                break;
            }
        }

        return cost;
    }

}
