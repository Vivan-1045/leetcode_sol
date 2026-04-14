package DP;

public class leetcode_97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        dp = new Boolean[s1.length()+1][s2.length()+1];
        if(s1.length()+s2.length() != s3.length()){
            return false;
        }
        return solve1(s1,s2,s3);
    }

    //Using Recursion
    Boolean [][] dp;
    boolean solve(String s1, String s2, String s3, int i, int j){
        if(i==s1.length() && j==s2.length()){
            return true;
        }

        if(dp[i][j] != null){
            return dp[i][j];
        }

        if(i<s1.length() && s1.charAt(i)==s3.charAt(i+j)){
            boolean f1 = solve(s1,s2,s3,i+1,j);
            if(f1){
                dp[i][j] = f1;
                return dp[i][j];
            }
        }

        if(j<s2.length() && s2.charAt(j)==s3.charAt(i+j)){
            boolean f2 = solve(s1,s2,s3,i,j+1);
            if(f2){
                dp[i][j] = f2;
                return dp[i][j];
            }
        }


        return dp[i][j] = false;
    }


    //Using Tabulation
    boolean solve1(String s1, String s2, String s3){
        int n = s1.length();
        int m = s2.length();

        boolean dp[][] = new boolean[n+1][m+1];
        dp[0][0] = true;

        for(int i = 1;i<=n;i++){
            if(s1.charAt(i-1)==s3.charAt(i-1) && dp[i-1][0]){
                dp[i][0] = true;
            }
        }

        for(int j = 1;j<=m;j++){
            if(s2.charAt(j-1)==s3.charAt(j-1) && dp[0][j-1]){
                dp[0][j] = true;
            }
        }

        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){

                if(s3.charAt(i+j-1)==s1.charAt(i-1)){
                    dp[i][j] = dp[i][j] || dp[i-1][j];
                }

                if(s3.charAt(i+j-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i][j] || dp[i][j-1];
                }
            }
        }

        return dp[n][m];
    }
}
