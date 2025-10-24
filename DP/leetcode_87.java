package DP;

import java.util.HashMap;
import java.util.Map;

public class leetcode_87 {
    Map<String,Boolean> mp;
    public boolean isScramble(String s1, String s2) {
        mp = new HashMap<>();
        if(s1.length()!=s2.length()){
            return false;
        }
        return solve(s1,s2);
    }


    boolean solve(String s1, String s2){

        String key = s1+"_"+s2;

        if(mp.containsKey(key)){
            return mp.get(key);
        }

        if(s1.equals(s2)){
            mp.put(key,true);
            return mp.get(key);
        }

        if(s1.length() != s2.length()){
            mp.put(key,false);
            return mp.get(key);
        }

        int n = s1.length();
        boolean isScramble = false;

        for(int i = 1;i<=n-1;i++){
            //When string swaped like : great , ategr
            boolean case1 = solve(s1.substring(0,i),s2.substring(n-i,n)) && solve(s1.substring(i,n),s2.substring(0,n-i));
            //When string not swaped like : great , great
            boolean case2 = solve(s1.substring(0,i),s2.substring(0,i)) && solve(s1.substring(i,n),s2.substring(i,n));

            if(case1 || case2){
                isScramble = true;
                break;
            }
        }

        mp.put(key,isScramble);
        return mp.get(key);
    }
}
