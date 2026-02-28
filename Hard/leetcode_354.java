package Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class leetcode_354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a, b) -> {
            if(a[0]==b[0]){
                return b[1]-a[1];
            }
            return a[0]-b[0];
        });
        // dp = new Integer[envelopes.length][envelopes.length+1];
        return solve1(envelopes);
    }

    Integer dp[][];

    //TLE
    int solve(int[][]arr,int idx,int preIdx){
        if(idx>=arr.length){
            return 0;
        }

        if(dp[idx][preIdx+1]!= null){
            return dp[idx][preIdx+1];
        }

        int add = 0;
        if(preIdx==-1||arr[preIdx][0]<arr[idx][0] && arr[preIdx][1]<arr[idx][1]){
            add = 1 + solve(arr,idx+1,idx);
        }

        int skip = solve(arr,idx+1,preIdx);

        return dp[idx][preIdx+1] = Math.max(add,skip);
    }

    //Optimal approach
    int solve1(int[][]arr){
        int n = arr.length;

        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(!ans.isEmpty() && arr[i][1]>ans.get(ans.size()-1)){
                ans.add(arr[i][1]);
            }else{
                int idx = Collections.binarySearch(ans,arr[i][1]);
                if(idx<0) idx = -idx-1;
                if(idx == ans.size()){
                    ans.add(arr[idx][1]);
                }else{
                    ans.set(idx , arr[i][1]);
                }
            }
        }

        return ans.size();
    }
}
