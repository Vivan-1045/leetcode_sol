package Contests;

import java.util.ArrayList;
import java.util.List;

public class weekly_02_19_01_25 {
    public static void main(String[] args) {
        int num[] = {0,1,1};
        int k = 3;

        int MOD = 1000000007;
        List<List<Integer>> subarrays = SubArraySum(num, k);
        int totalSum = 0;
        for (List<Integer> subarray : subarrays) {
            if (subarray.size() < 2) {
                for (int numInSubarray : subarray) {
                    totalSum = (totalSum+numInSubarray)%MOD;
                }
            }
            for (int numInSubarray : subarray) {
                totalSum += numInSubarray;

            }
        }

        System.out.println(totalSum);

    }
    public static List<List<Integer>> SubArraySum(int[] num,int k){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        for (int n : num){
            int m = outer.size();
            for (int i =0;i<m;i++){
                List<Integer> internal = new ArrayList<>(outer.get(i));
                if (internal.size() < k) {
                    internal.add(n);
                    outer.add(internal);
                }
            }
        }

     return outer;
    }
}
