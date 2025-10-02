package Prefix_Sum;

import java.util.HashMap;
import java.util.Map;

public class leetcode_560 {
    public int subarraySum(int[] nums, int k) {
        return totalSub2(nums,k);
    }

    int totalSub(int[] arr, int k){
        int n = arr.length;
        int cnt = 0;

        for(int i = 0;i<n;i++){
            int sum = 0;
            for(int j = i;j<n;j++){
                sum += arr[j];
                if(sum==k){
                    cnt++;
                }
            }
        }

        return cnt;
    }


    int totalSub2(int[]arr,int k){
        Map<Integer,Integer> mp = new HashMap<>();

        int res = 0;
        int currSum = 0;
        mp.put(currSum,1);

        for(int i = 0;i<arr.length;i++){
            currSum += arr[i];
            if(mp.containsKey(currSum-k)){
                res += mp.get(currSum-k);
                mp.put(currSum,mp.getOrDefault(currSum,0)+1);
            }else{
                mp.put(currSum,mp.getOrDefault(currSum,0)+1);
            }
        }

        return res;
    }
}
