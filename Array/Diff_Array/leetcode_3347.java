package Array.Diff_Array;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class leetcode_3347 {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        return maxFreq(nums,k,numOperations);
    }

    int maxFreq(int[] arr, int k, int numOpr){
        int maxEle = 0;
        for(int ele:arr){
            maxEle = Math.max(ele,maxEle);
        }
        maxEle +=k;

        TreeMap<Integer,Integer> mp = new TreeMap<>();
        Map<Integer,Integer> freqMap = new HashMap<>();

        for(int i = 0;i<arr.length;i++){
            freqMap.put(arr[i],freqMap.getOrDefault(arr[i],0)+1);

            int l = Math.max(arr[i]-k,0);
            int r = Math.min(arr[i]+k,maxEle);

            mp.put(l,mp.getOrDefault(l,0)+1);
            mp.put(r+1,mp.getOrDefault(r+1,0)-1);

            mp.putIfAbsent(arr[i],mp.getOrDefault(arr[i],0));
        }

        int res = 1;
        int cumSum = 0;

        for(Map.Entry<Integer,Integer> entry: mp.entrySet()){
            int target = entry.getKey();
            int val = entry.getValue();

            cumSum += val;

            int targetFreq = freqMap.getOrDefault(target,0);
            int conversionNeed = cumSum - targetFreq;

            int maxPossibleFreq = Math.min(conversionNeed,numOpr)+ targetFreq;

            res= Math.max(res,maxPossibleFreq);
        }

        return res;
    }
}
