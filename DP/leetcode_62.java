package DP;

public class leetcode_62 {
    int a=0,b=0;
    int[][]dp;
    public int uniquePaths(int m, int n) {
        a = m;
        b = n;
        dp=new int[m+1][n+1];


        return uniquePath(0,0);
    }
    int uniquePath(int m, int n){
        if(m==a-1 || n==b-1){
            return 1;
        }

        if(dp[m][n] != 0){
            return dp[m][n];
        }

        int left = uniquePath(m+1,n);
        int right = uniquePath(m,n+1);

        return dp[m][n] = left+right;
    }
}
