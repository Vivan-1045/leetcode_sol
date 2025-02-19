package Backtracking;

import java.util.*;

public class leetcode_1415 {
    public static void main(String[] args) {
        int k = 9;
        int n = 3;
        System.out.println(lexoSmallString(n,k));
    }
    public static String lexoSmallString(int n,int k){
        StringBuilder ans = new StringBuilder();
        Stack<String> st = new Stack<>();

        helper(n,ans,st,k);

        if (st.size()==k){
            return st.pop();
        }
        return "";
    }
    public static void helper(int n,StringBuilder ans,Stack<String> st,int k){
        if (st.size()==k){
            return;
        }
        if (ans.length()==n){
            st.push(ans.toString());
            return;
        }
        String s = "abc";
        for (int i = 0;i<3;i++){

            if (ans.length()==0 || (ans.length()>0 && ans.charAt(ans.length()-1)!=s.charAt(i))) {
                ans.append(s.charAt(i));
                helper(n,ans,st,k);
                ans.deleteCharAt(ans.length()-1);
            }

        }

        return;
    }
}
