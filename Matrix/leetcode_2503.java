package Matrix;

import java.util.Arrays;

public class leetcode_2503 {
    public static void main(String[] args) {
        int[] num = {5};
        int[][] grid = {{5,2,1},{1,1,2}};
        System.out.println(Arrays.toString(ans(grid,num)));
    }
    public static int[] ans(int[][] grid,int[] num){
        int n = num.length;
        int[] res = new int[n];


        for (int i = 0;i<n;i++){
            boolean [][]visit = new boolean[grid.length][grid[0].length];
            res[i] = check(grid,0,0,num[i],visit);

        }
        return res;
    }
    public static int check(int[][] grid,int i,int j,int currVal,boolean[][] visit){
        //Base condition
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visit[i][j] || grid[i][j] >= currVal) {
            return 0;
        }


        int res = 1;

        visit[i][j] = true;

        res += check(grid,i-1,j,currVal,visit);
        res += check(grid,i+1,j,currVal,visit);
        res += check(grid,i,j-1,currVal,visit);
        res += check(grid,i,j+1,currVal,visit);



        return res;
    }
}
