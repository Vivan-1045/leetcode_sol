package Backtracking;

public class leetcode_79 {
    public boolean exist(char[][] board, String word) {
        return solve(board,word);
    }

    boolean solve(char[][] board, String word){
        int n = board.length;
        int m = board[0].length;

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(board[i][j] ==  word.charAt(0) && backTrack(board,word,i,j,0)){
                    return true;
                }
            }
        }

        return false;
    }

    boolean backTrack(char[][] grid, String s, int i, int j, int idx){
        if(idx==s.length()){
            return true;
        }

        if(i<0||j<0||i>grid.length-1||j>grid[0].length-1||grid[i][j]=='$'||grid[i][j] != s.charAt(idx)){
            return false;
        }

        //Do
        char temp = grid[i][j];
        grid[i][j] = '$';

        //Explore
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int [] d : dir){
            int r = i + d[0];
            int c = j + d[1];

            if(backTrack(grid,s,r,c,idx+1)){
                return true;
            }
        }

        //Undo
        grid[i][j] = temp;

        return false;
    }
}
