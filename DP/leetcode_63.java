package DP;

import java.util.Arrays;

public class leetcode_63 {
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        dp = new int[n][m];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }

        return uniquePath2(obstacleGrid,0,0);
    }
    int uniquePath2(int[][]mat,int i ,int j){

        //Check if i and j goes out of bound
        if(i>=mat.length || j>= mat[0].length){
            return 0;
        }

        //Check if i and j reaches the destination return 1 means we found a path
        if(i==mat.length-1 && j==mat[0].length-1 && mat[i][j] !=1){
            return 1;
        }

        //Check if we are on obstackle
        //If we are on obstackle return 0 means we did not found any path through this way
        if(mat[i][j]==1){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        //Go right
        int r = uniquePath2(mat,i,j+1);
        //Go down
        int d = uniquePath2(mat,i+1,j);

        //Return if we found a path
        return dp[i][j] = r+d;
    }
}
