package DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leetcode_873 {
    public static void main(String[] args) {
        int [] arr = {1,3,7,11,12,14,18};
        System.out.println(maxLength(arr));
    }
    public static int maxLength(int[] arr){
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            mp.put(arr[i], i);
        }

        int maxlen = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int length = solve(i, j, arr, mp);
                if (length >= 3) {
                    maxlen = Math.max(maxlen, length);
                }
            }
        }
        return maxlen;
    }
    
    public static int solve(int i , int j, int[] arr, Map<Integer,Integer> mp){
        int sum = arr[i] + arr[j];
        if (mp.containsKey(sum)) {
            int k = mp.get(sum);
            return solve(j, k, arr, mp) + 1;
        }
        return 2;
    }
}
