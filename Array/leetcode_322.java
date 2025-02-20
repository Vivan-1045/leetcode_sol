package Array;

import java.util.*;
import java.util.stream.IntStream;

public class leetcode_322 {
    public static void main(String[] args) {
        int [] arr = {1,2,5};
        int k = 11;
        Map<Integer,Integer> memo = new HashMap<>();
        System.out.println(helper(arr,k,memo));;
    }
    public static int helper(int [] arr, int k,Map<Integer,Integer> memo){
        if (k==0){
            return 0;
        }

        if (memo.containsKey(k)){
            return memo.get(k);
        }

        int res = Integer.MAX_VALUE;

        for (int i =0;i<arr.length;i++){
            if (k-arr[i]>=0){
                int  currRes = helper(arr,k-arr[i],memo);
                 if (currRes !=-1){
                     res = Math.min(currRes+1,res);
                 }
            }
        }

        //if No valid solution found then store -1 or mini count in the map
        int result = res==Integer.MAX_VALUE?-1:res;
        memo.put(k,result);
        return result;
    }
}
