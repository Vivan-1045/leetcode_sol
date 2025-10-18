package DP;

public class leetcode_516 {
    public int longestPalindromeSubseq(String s) {
        return longestPalind(s);
    }
    int longestPalind(String s){
        String s1 = "";
        for(int i = s.length()-1;i>=0;i--){
            s1 += s.charAt(i);
        }

        int n = s1.length();
        int[][] dp = new int[n+1][n+1];

        for(int i = 0;i<=n;i++){
            for(int j = 0;j<=n;j++){
                if(i==0||j==0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i = 1;i<n+1;i++){
            for(int j = 1;j<n+1;j++){
                if(s.charAt(i-1)==s1.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }

        return dp[n][n];
    }
}
