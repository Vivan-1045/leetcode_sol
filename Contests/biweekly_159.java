package Contests;

import java.util.*;

public class biweekly_159 {
    public static void main(String[] args) {
        int[] arr ={2,3,5,7};
        System.out.println(primeSubArray(arr,3));
    }
    public static int minSwap(int[] arr){
        int odd = 0,even = 0;
        int ans = Integer.MAX_VALUE;
        for (int num : arr){
            if (num%2==0){ even++;
            }else {
                odd++;
            };
        }
        if (Math.abs(even-odd)>1) return -1;

        if (even>odd) {
            ans = Math.min(ans,swapCount(arr,0));
        }
        else{
            ans = Math.min(ans,swapCount(arr,1));
        }

        return ans;
    }

    public static int swapCount(int[]arr ,int parityType){
        int totalSwap = 0;
        int curr = 0;
        for (int i = 0;i<arr.length;i++){
            if (arr[i]%2==parityType){
                totalSwap += Math.abs(i-curr);
                curr += 2;
            }
        }
        return totalSwap;
    }

    public static int primeSubArray(int[] nums, int k) {
        int n = nums.length;
        boolean[] isPrime = sieve(50000);
        List<Integer> primeList = new ArrayList<>();

        for (int num : nums) {
            if (isPrime[num]) {
                primeList.add(num);
            }
        }

        int count = 0;
        int left = 0;

        Deque<Integer> minDeque = new ArrayDeque<>();
        Deque<Integer> maxDeque = new ArrayDeque<>();

        for (int right = 0; right < primeList.size(); right++) {
            int current = primeList.get(right);

            while (!minDeque.isEmpty() && minDeque.peekLast() > current) {
                minDeque.pollLast();
            }
            minDeque.offerLast(current);

            while (!maxDeque.isEmpty() && maxDeque.peekLast() < current) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(current);

            while (!minDeque.isEmpty() && !maxDeque.isEmpty() &&
                    maxDeque.peekFirst() - minDeque.peekFirst() > k) {

                int leftVal = primeList.get(left);

                if (!minDeque.isEmpty() && minDeque.peekFirst() == leftVal) minDeque.pollFirst();
                if (!maxDeque.isEmpty() && maxDeque.peekFirst() == leftVal) maxDeque.pollFirst();

                left++;
            }

            if (right - left + 1 >= 2) {
                count += (right - left);
            }
        }

        return count;
    }

    public static boolean[] sieve(int max) {
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= max; i+=2) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
