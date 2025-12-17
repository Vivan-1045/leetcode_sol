package DP;

public class leetcode_3573 {
    public long maximumProfit(int[] prices, int k) {
        dp = new Long[prices.length+1][(prices.length/2)+1][3];
        return maxProfit(0,k,0,prices);
        // return usingDP(k,prices);
    }
    Long[][][]dp;
    long maxProfit(int i,int k, int CASE, int[] prices){

        if(i>=prices.length){
            if(CASE==0){
                return 0;
            }
            return Integer.MIN_VALUE;
        }

        if(dp[i][k][CASE] != null){
            return dp[i][k][CASE];
        }


        long skip = maxProfit(i+1,k,CASE,prices);
        long add = Integer.MIN_VALUE;

        if(k>0){
            if(CASE==2){ //case == 2 means want to buy
                add = -prices[i] + maxProfit(i+1,k-1,0,prices);
            }
            else if(CASE==1){ //case == 1 means want to sell
                add = prices[i] + maxProfit(i+1,k-1,0,prices);
            }
            else{ //case == 0 , either we can sell or buy the stock
                add = Math.max(
                        -prices[i]+maxProfit(i+1,k,1,prices),
                        prices[i]+maxProfit(i+1,k,2,prices)
                );
            }
        }

        return dp[i][k][CASE] = Math.max(skip,add);
    }
}
