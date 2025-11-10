package Graph;

public class leetcode_1020 {
    public int numEnclaves(int[][] grid) {
        return enclaveCnt(grid);
    }

    int enclaveCnt(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;

        int[][] vis = new int[n][m];

        for(int j = 0;j<m;j++){

            if(vis[0][j]==0 && mat[0][j]==1){
                dfs(0,j,mat,vis);
            }

            if(vis[n-1][j]==0 && mat[n-1][j]==1){
                dfs(n-1,j,mat,vis);
            }
        }

        for(int i =0;i<n;i++){
            if(vis[i][0]==0 && mat[i][0]==1){
                dfs(i,0,mat,vis);
            }

            if(vis[i][m-1]==0 && mat[i][m-1]==1){
                dfs(i,m-1,mat,vis);
            }
        }

        int cnt = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(vis[i][j]==0 && mat[i][j]==1){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    int[]delRow = {0,1,0,-1};
    int[]delCol = {1,0,-1,0};

    void dfs(int r, int c , int[][] mat, int[][] vis){
        vis[r][c] =1;
        mat[r][c] = 2;

        int n = mat.length;
        int m = mat[0].length;

        for(int i = 0;i<4;i++){
            int nR = r + delRow[i];
            int nC = c + delCol[i];

            if(nR>=0 && nC>=0 &&nR<n&&nC<m&& vis[nR][nC]==0 && mat[nR][nC]==1){
                dfs(nR,nC,mat,vis);
            }
        }
    }
}
