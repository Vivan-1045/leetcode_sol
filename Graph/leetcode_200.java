package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_200 {
    static class Pair{
        int f;
        int s;

        Pair(int f, int s){
            this.f = f;
            this.s = s;
        }
    }


    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int ans = 0;

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(vis[i][j] == false && grid[i][j]=='1'){
                    ans++;
                    bfs(i,j,vis,grid);
                }
            }
        }

        return ans;
    }

    int[] dRow = {-1,1,0,0};
    int[] dCol = {0,0,-1,1};

    void bfs(int i, int j, boolean[][] vis, char[][] grid){
        vis[i][j] = true;
        Queue<Pair> que = new LinkedList<Pair>();
        que.add(new Pair(i,j));

        int n = grid.length;
        int m = grid[0].length;

        while(!que.isEmpty()){
            int r = que.peek().f;
            int c = que.peek().s;
            que.remove();

            for (int k = 0; k < 4; k++) {
                int nRow = r + dRow[k];
                int nCol = c + dCol[k];

                if(nRow>=0 && nRow < n && nCol>=0 && nCol < m && grid[nRow][nCol]=='1' && vis[nRow][nCol] == false){
                    vis[nRow][nCol] = true;
                    que.add(new Pair(nRow, nCol));
                }
            }
        }
    }
}
