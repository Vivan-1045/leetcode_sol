package Hard;

import java.util.Arrays;

public class leetcode_329 {
    public int longestIncreasingPath(int[][] matrix) {
        return solve(matrix);
    }

    int[][]dp;
    int solve(int[][]arr){
        int n = arr.length;
        int m = arr[0].length;
        dp = new int[n][m];

        for(int a[]:dp){
            Arrays.fill(a,-1);
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                max = Math.max(max,dfs(i,j,arr));
            }
        }

        return max;
    }

    int [][]dir = {{-1,0},{1,0},{0,1},{0,-1}};

    int dfs(int i, int j, int[][]arr){
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int maxLen = 1;

        for(int x = 0;x<4;x++){
            int ni = i + dir[x][0];
            int nj = j + dir[x][1];

            if(ni<arr.length && nj<arr[0].length && ni>=0 && nj>=0 && arr[ni][nj]>arr[i][j]){
                maxLen = Math.max(maxLen,1 + dfs(ni,nj,arr));
            }
        }

        return dp[i][j] = maxLen;
    }
}
