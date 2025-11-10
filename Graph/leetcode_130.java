package Graph;

public class leetcode_130 {
    public void solve(char[][] board) {
        helper(board);
    }

    void helper(char[][] board){
        int n = board.length;
        int m = board[0].length;

        int[][] vis = new int[n][m];

        int []delRow = {0,-1,1,0};
        int []delCol = {1,0,0,-1};

        //For first and last Row
        for(int j = 0;j<m;j++){
            //first row
            if(board[0][j]=='O' && vis[0][j]==0){
                dfs(0,j,board,vis,delRow,delCol);
            }

            //last row
            if(vis[n-1][j]==0 && board[n-1][j]=='O'){
                dfs(n-1,j,board,vis,delRow,delCol);
            }
        }

        //For first and last Col
        for(int i = 0;i<n;i++){
            //first col
            if(vis[i][0]==0 && board[i][0]=='O'){
                dfs(i,0,board,vis,delRow,delCol);
            }

            //last col
            if(vis[i][m-1]==0 && board[i][m-1]=='O'){
                dfs(i,m-1,board,vis,delRow,delCol);
            }
        }

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(vis[i][j]==0){
                    board[i][j]='X';
                }
            }
        }

    }

    void dfs(int r, int c, char[][]board,int[][] vis,int[]delRow, int []delCol){
        vis[r][c] = 1;
        int n = board.length;
        int m = board[0].length;

        for(int i = 0;i<4;i++){
            int nR = r +delRow[i];
            int nC = c + delCol[i];

            if(nR>=0 && nR<n && nC>=0 && nC<m && vis[nR][nC]==0 && board[nR][nC]=='O'){
                dfs(nR,nC,board,vis,delRow,delCol);
            }
        }
    }
}
