package Hard;

public class leetcode_741 {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        dp = new Integer[n][n][n][n];
        return Math.max(0,solve(0,0,0,0,grid));
    }

    Integer dp[][][][];

    int solve(int i1,int j1, int i2, int j2,int[][]arr){

        if(i1>=arr.length || i2>=arr.length || j2>=arr[0].length||j1>=arr[0].length||arr[i1][j1]==-1 || arr[i2][j2]==-1){
            return Integer.MIN_VALUE;
        }

        if(dp[i1][j1][i2][j2] != null){
            return dp[i1][j1][i2][j2];
        }

        if(i1==arr.length-1 && j1==arr.length-1){
            return dp[i1][j1][i2][j2] = arr[i1][j1];
        }

        int che = 0;

        if(i1==i2 && j1==j2){
            che += arr[i1][j1];
        }else{
            che += arr[i1][j1] + arr[i2][j2];
        }

        int a1 = solve(i1+1,j1,i2+1,j2,arr);
        int a2 = solve(i1,j1+1,i2+1,j2,arr);
        int a3 = solve(i1,j1+1,i2,j2+1,arr);
        int a4 = solve(i1+1,j1,i2,j2+1,arr);

        che += Math.max(Math.max(a1,a2),Math.max(a3,a4));
        return dp[i1][j1][i2][j2] = che;
    }
}
