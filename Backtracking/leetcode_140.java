package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class leetcode_140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        solve(0,s,wordDict,"");
        return res;
    }
    List<String> res = new ArrayList<>();

    void solve(int i, String s, List<String> wordDict,String curr){
        if(i>=s.length()){
            res.add(curr);
            return;
        }


        for(int j = i;j<s.length();j++){
            String temp = s.substring(i,j+1);
            if(wordDict.contains(temp)){
                String currTemp = curr;

                if(!curr.isEmpty()){
                    curr += " ";
                }

                curr += temp;
                solve(j+1,s,wordDict,curr);
                curr = currTemp;
            }
        }

    }
}
