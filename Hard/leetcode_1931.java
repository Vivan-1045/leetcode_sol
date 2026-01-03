package Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_1931 {
    List<String> list = new ArrayList<>();
    int M = 1000000007;
    int [][] dp;
    public int colorTheGrid(int m, int n) {
        return totalWay(m,n);
    }
    int totalWay(int m, int n){
        generateState("",'$',m);

        dp = new int[n][list.size()];
        for(int []a: dp){
            Arrays.fill(a,-1);
        }
        int res = 0;
        for(int i = 0;i<list.size();i++){
            res = (res + solve(n-1,i,m))%M;
        }

        return res;
    }

    void generateState(String curr, char prevChar, int col){
        if(col==0){
            list.add(curr);
            return;
        }

        for(char ch : new char[]{'R','G','B'}){
            if(ch==prevChar){
                continue;
            }
            generateState(curr+ch,ch,col-1);
        }
    }

    int solve(int remainCol,int prevIdx, int row){
        if(remainCol==0){
            return 1;
        }

        if(dp[remainCol][prevIdx] != -1){
            return dp[remainCol][prevIdx];
        }

        int ways = 0;
        String lastString = list.get(prevIdx);
        for(int i = 0;i<list.size();i++){
            if(i==prevIdx){
                continue;
            }

            String currString = list.get(i);
            boolean valid = false;
            for(int j = 0;j<row;j++){
                if(lastString.charAt(j)==currString.charAt(j)){
                    valid = true;
                    break;
                }
            }

            if(!valid){
                ways = (ways + solve(remainCol-1,i,row))%M;
            }



        }
        return dp[remainCol][prevIdx]  = ways;
    }
}
