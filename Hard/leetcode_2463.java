package Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class leetcode_2463 {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        return minTotalDis(robot,factory);
    }

    long minTotalDis(List<Integer> rb , int[][]fact){
        List<Integer> totalFact = new ArrayList<>();

        for(int []a : fact){
            while(a[1]-->0){
                totalFact.add(a[0]);
            }
        }

        dp = new Long[rb.size()+1][totalFact.size()+1];
        Collections.sort(rb);
        Collections.sort(totalFact);

        return solve(0,rb,0,totalFact);
    }
    Long [][]dp;


    long solve(int i, List<Integer> rb, int j, List<Integer> fc){
        if(i>=rb.size()){
            return 0;
        }

        if(j>=fc.size()){
            return Long.MAX_VALUE/2;
        }

        if(dp[i][j] != null){
            return dp[i][j];
        }

        long take = Math.abs(rb.get(i)-fc.get(j)) + solve(i+1,rb,j+1,fc);
        long skip = solve(i,rb,j+1,fc);

        return dp[i][j] = Math.min(take,skip);
    }
}
