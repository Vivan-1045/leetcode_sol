package DP;

import java.util.*;

public class leetcode_3186 {
    public long maximumTotalDamage(int[] power) {
        return maxTotal(power);
    }
    long []dp;
    Map<Long,Long> mp = new HashMap<>();
    long maxTotal(int[] arr){

        for(int i = 0;i<arr.length;i++){
            mp.put((long)arr[i],mp.getOrDefault((long)arr[i],0L)+1);
        }

        List<Long> ls = new ArrayList<>(mp.keySet());
        Collections.sort(ls);

        dp = new long[arr.length+1];
        Arrays.fill(dp,-1);

        return Solve(ls,0);
    }

    long Solve(List<Long> ls , int idx){
        if(idx>=ls.size()){
            return 0;
        }

        if(dp[idx] != -1){
            return dp[idx];
        }

        long skip = Solve(ls,idx+1);

        int j = getIdx(ls,idx+1,ls.get(idx)+3);
        long take = ls.get(idx)*mp.get(ls.get(idx)) + Solve(ls,j);

        return dp[idx] = Math.max(skip,take);
    }

    int getIdx(List<Long> ls, int start , long tar){
        int s = start;
        int e = ls.size();

        while(s<e){
            int m = s + (e-s)/2;
            if(ls.get(m)<tar){
                s = m+1;
            }else{
                e = m;
            }
        }

        return s;
    }
}
