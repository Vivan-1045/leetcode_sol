package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class leetcode_1239 {
    public int maxLength(List<String> arr) {
        getAll(arr,0,new ArrayList<>());
        int res = Integer.MIN_VALUE;

        for(List<String> s2 : ans){
            String s1 = "";
            int[]freq = new int[26];
            for(String s : s2){
                s1 += s;
            }

            for(char ch : s1.toCharArray()){
                freq[ch-'a']++;
            }

            boolean dup = false;
            for(int f : freq){
                if(f>=2){
                    dup = true;
                    break;
                }
            }

            if(dup!=true){
                res = Math.max(res,s1.length());
            }
        }

        return res;
    }

    List<List<String>> ans = new ArrayList<>();

    void getAll(List<String> arr,int idx,List<String> curr){
        if(idx>=arr.size()){
            ans.add(new ArrayList<>(curr));
            return;
        }

        curr.add(arr.get(idx));
        getAll(arr,idx+1,curr);
        curr.remove(curr.size()-1);
        getAll(arr,idx+1,curr);
    }
}
