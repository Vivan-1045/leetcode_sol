package Sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode_187 {
    public static void main(String[] args) {
        String s ="AAAAAAAAAAA";
        System.out.println(getRepeatedDNA(s));
    }
    public static List<String> getRepeatedDNA(String s){
        if (s.length()<9){
            return new ArrayList<>();
        }
        Map<String,Integer> mp = new HashMap<>();
        List<String> ans = new ArrayList<>();

        for (int i = 0;i<s.length();i++){
            if(i+10>s.length()){
                break;
            }
            String sub = s.substring(i,i+10);
            mp.put(sub,mp.getOrDefault(sub,0)+1);
        }

        for (Map.Entry<String,Integer> entry : mp.entrySet()){
            if (entry.getValue()>1){
                ans.add(entry.getKey());
            }
        }
        return ans;
    }
}
