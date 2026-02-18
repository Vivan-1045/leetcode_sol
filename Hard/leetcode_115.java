package Hard;

import java.util.Arrays;

public class leetcode_115 {
    public int numDistinct(String s, String t) {
        dp = new int[s.length()+1][t.length()+1];
        for(int []a: dp){
            Arrays.fill(a,-1);
        }
        return solve(0,0,s,t);
    }
    int dp[][];
    int solve(int i, int j , String s, String t){
        if(j==t.length()){
            return 1;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(i==s.length()){
            return 0;
        }

        if(s.charAt(i)==t.charAt(j)){
            dp[i][j] = solve(i+1,j,s,t) + solve(i+1,j+1,s,t);
            return dp[i][j];
        }

        dp[i][j] = solve(i+1,j,s,t);
        return dp[i][j];
    }
}
