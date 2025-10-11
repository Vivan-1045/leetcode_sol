package DP;

public class leetcode_322 {
    int [][]dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length+1][amount+1];
        return minCount(coins,amount);
    }

    int minCount(int[] coin, int amo){
        int n = coin.length;

        //Initialization
        for(int j= 1;j<=amo;j++){
            dp[0][j] = Integer.MAX_VALUE-1;

            dp[1][j] = j%coin[0]==0?j/coin[0]:Integer.MAX_VALUE-1;
        }

        //Core logic
        for(int i = 2;i<=n;i++){
            for(int j = 1;j<=amo;j++){
                if(coin[i-1]<=j){
                    dp[i][j] = Math.min(dp[i][j-coin[i-1]]+1,dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][amo]==Integer.MAX_VALUE-1?-1:dp[n][amo];
    }
}
