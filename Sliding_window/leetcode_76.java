package Sliding_window;

import java.util.HashMap;
import java.util.Map;

public class leetcode_76 {
    public String minWindow(String s, String t) {
        return minWin(s,t);
    }

    String minWin(String s, String t){
        if(s.length()<t.length()){
            return "";
        }

        Map<Character,Integer> mp = new HashMap<>();
        for(char ch : t.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }

        Map<Character,Integer> mp1 = new HashMap<>();
        int l = 0;
        int r = 0;
        int n = s.length();
        int maxLen = Integer.MAX_VALUE;
        int minI = -1;
        int minJ = -1;

        while(r<n){
            mp1.put(s.charAt(r),mp1.getOrDefault(s.charAt(r),0)+1);

            while(isContains(mp,mp1)){
                if(maxLen>r-l+1){
                    minI = l;
                    minJ = r;
                    maxLen = r-l+1;
                }

                char leftCh = s.charAt(l);
                mp1.put(leftCh,mp1.get(leftCh)-1);
                l++;
            }
            r++;
        }

        return minI==-1?"":s.substring(minI,minJ+1);
    }

    boolean isContains(Map<Character,Integer> mp, Map<Character,Integer> mp1){
        for(Map.Entry<Character,Integer> entry : mp.entrySet()){
            char ch = entry.getKey();
            int val = entry.getValue();
            if(mp1.getOrDefault(ch,0)<val){
                return false;
            }
        }
        return true;
    }
}
