package DP;

import java.util.List;

public class leetcode_139 {
    public static void main(String[] args) {

    }
    static Boolean [] t = new Boolean[301];
    public static boolean isPossible(int idx, String s, List<String> wordDict){
        if(idx==s.length()){
            return true;
        }

        if(t[idx] != null){
            return t[idx];
        }

        for(int i = idx+1;i<= s.length();i++){
            String st = s.substring(idx, i);
            if(wordDict.contains(st) && isPossible(i,s,wordDict)){
                return t[idx] = true;
            }
        }

        return t[idx] = false;
    }
}
