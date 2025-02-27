package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class leetcode_22 {
    public static void main(String[] args) {
        int n = 2;
        List<String> st = new ArrayList<>();
        System.out.println(genretedParenthesis(0,0,"",st,n));

    }
    public static List<String> genretedParenthesis(int open , int close, String s, List<String> res, int n){
        if (open==close && open+close == 2*n){
           res.add(s);
        }
        if (open<n){
            genretedParenthesis(open+1,close,s+"(",res,n);
        }
        if (close<open){
            genretedParenthesis(open,close+1,s+")",res,n);
        }
        return res;
    }
}
