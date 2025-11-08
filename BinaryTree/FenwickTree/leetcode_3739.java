package BinaryTree.FenwickTree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class leetcode_3739 {
    public long countMajoritySubarrays(int[] nums, int target) {
        return cntSub(nums,target);
    }

    long cntSub(int[]arr, int target){
        int n = arr.length;
        int []a = new int[n];

        for(int i = 0;i<n;i++){
            a[i] = arr[i]==target?1:-1;
        }

        long []preSum = new long[n+1];
        for(int i = 0;i<n;i++){
            preSum[i+1] = preSum[i] + a[i];
        }

        long[] sortedArray = Arrays.copyOf(preSum,preSum.length);
        Arrays.sort(sortedArray);

        int idx = 1;
        Map<Long,Integer> mp = new HashMap<>();
        for(long ele : sortedArray){
            if(!mp.containsKey(ele)){
                mp.put(ele,idx++);
            }
        }

        FenTree b = new FenTree(idx+2);
        long cnt = 0;
        for(long ele : preSum){
            int get = mp.get(ele);
            cnt += b.query(get-1);
            b.update(get,1);
        }

        return cnt;
    }

    class FenTree{
        int n;
        int[]tree;

        FenTree(int n){
            this.n=n;
            tree = new int[n+1];
        }

        void update(int i, int changes){
            while(i<tree.length){
                tree[i]+= changes;
                i += i&-i;
            }
        }

        int query(int key){
            int sum = 0;
            while(key>0){
                sum += tree[key];
                key -= key & -key;
            }

            return sum;
        }


    }

    //TLE
    long solve(int[]arr, int target){
        int n = arr.length;
        int[]a = new int[n];

        for(int i = 0;i<n;i++){
            a[i] = arr[i]==target?1:-1;
        }

        long []preSum = new long[n+1];

        for(int i = 0;i<n;i++){
            preSum[i+1] = preSum[i]+a[i];
        }

        TreeMap<Long,Integer> mp = new TreeMap<>();
        long cnt = 0;

        for(long ele : preSum){
            cnt += mp.headMap(ele,false).values().stream().mapToInt((Integer::intValue)).sum();
            mp.put(ele,mp.getOrDefault(ele,0)+1);
        }
        return cnt;
    }


}
