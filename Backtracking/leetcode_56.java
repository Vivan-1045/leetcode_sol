package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class leetcode_56 {
    public List<List<String>> solveNQueens(int n) {
        boolean arr[][] = new boolean[n][n];
        safeQueen(arr,0);
        return res;
    }

    List<List<String>> res = new ArrayList<>();

    void safeQueen(boolean[][] board,int r){
        if(r == board.length){
            List<String> curr = new ArrayList<>();
            for(boolean[] arr : board){
                String s="";
                for(boolean ele: arr){
                    if(ele){
                        s +="Q";
                    }else{
                        s+=".";
                    }
                }
                curr.add(s);
            }
            res.add(curr);
            return;
        }


        for(int c = 0;c<board.length;c++){
            if(isSafe(board,r,c)){
                board[r][c] = true;
                safeQueen(board,r+1);
                board[r][c] = false;
            }
        }
    }

    boolean isSafe(boolean[][] board,int r, int c){
        //for vertical
        for(int i = 0;i<r;i++){
            if(board[i][c]){
                return false;
            }
        }

        //left diagonal
        int maxL = Math.min(r,c);
        for(int i = 1;i<=maxL;i++){
            if(board[r-i][c-i]){
                return false;
            }
        }

        //right diagonal
        int maxR = Math.min(r,board.length-c-1);
        for(int i = 1;i<=maxR;i++){
            if(board[r-i][c+i]){
                return false;
            }
        }

        return true;
    }
}
