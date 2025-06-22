package Sliding_window;

import java.util.*;

public class leetcode_438 {
    public static void main(String[] args) {
        System.out.println(allAnagram("aaabb","bb"));
    }
    public static List<Integer> allAnagram(String s,String p){
        int n = p.length();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0;i<s.length();i++){
           if (i+n-1<s.length() && isAnagram(s.substring(i,i+n),p)){
               ans.add(i);
           }
        }
        return ans;
    }
    public static boolean isAnagram(String s1, String s2){
        int[] freq = new int[26];
        for (int i = 0;i<s1.length();i++){
            freq[s1.charAt(i)-'a']++;
            freq[s2.charAt(i)-'a']--;
        }
        for (int num : freq){
            if (num != 0){
                return false;
            }
        }
        return true;

    }

}
