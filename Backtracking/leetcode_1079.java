package Backtracking;

import com.sun.source.doctree.SeeTree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class leetcode_1079 {
    public static void main(String[] args) {
      String tile = "AAABBC";
      System.out.println(sequence(tile));
    }

    public static int sequence(String s){
        int n = s.length();
        Set<String> st = new HashSet<>();
        boolean [] used = new boolean[n];
        Arrays.fill(used,false);
        StringBuilder currString = new StringBuilder();
        helper(st,used,s,currString);

        return st.size()-1;
    }

    public static void helper(Set<String> set , boolean [] used , String tile,StringBuilder curr){
        set.add(curr.toString());
        for (int i =0;i<tile.length();i++){
            if (used[i]){
                continue;
            }
            //Do
            curr.append(tile.charAt(i));
            used[i] = true;

            //Explore
            helper(set,used,tile,curr);

            //undo
            used[i] = false;
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
