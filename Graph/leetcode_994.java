package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_994 {
    class Pair{
        int r;
        int c;
        int tm;

        Pair(int r, int c, int tm){
            this.r = r;
            this.c = c;
            this.tm = tm;
        }
    }

    public int orangesRotting(int[][] grid) {
        return minTime(grid);
    }

    int minTime(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        int freshCnt = 0;
        int [][]vis = new int[n][m];

        Queue<Pair> qu = new LinkedList<>();

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]==2){
                    qu.add(new Pair(i,j,0));
                    vis[i][j] = 2;
                }else{
                    vis[i][j] = 0;
                }

                if(grid[i][j]==1){
                    freshCnt++;
                }
            }
        }


        int tm = 0;
        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};
        int cnt = 0;

        while(!qu.isEmpty()){
            int r = qu.peek().r;
            int c = qu.peek().c;
            int t = qu.peek().tm;
            tm = Math.max(tm,t);
            qu.remove();

            for(int i = 0;i<4;i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol] != 2 && grid[nrow][ncol] == 1){
                    qu.add(new Pair(nrow,ncol,t+1));
                    vis[nrow][ncol] = 2;
                    cnt++;
                }
            }
        }

        return  cnt != freshCnt ?-1:tm;
    }
}
