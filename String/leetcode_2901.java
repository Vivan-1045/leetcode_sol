package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class leetcode_2901 {
    public static void main(String[] args) {
        String[] words = {"bab","dab","cab"};
        int[] group = {1,2,2};
        System.out.println(getLongestSequence(words,group));
    }
    public static List<String> getLongestSequence(String [] words,int[] group){
        List<String> ans = new ArrayList<>();
        int n = words.length;

        int []dp = new int[n];
        int []pt = new int[n];

        int longestSub = -1;
        int longestSubIdx = 0;

        Arrays.fill(dp,1);
        Arrays.fill(pt,-1);


        for (int i = 0;i<n;i++){
           for (int j = 0;j<=i-1;j++){
               if (group[j] != group[i] && words[i].length() == words[j].length() && HammingOne(words[i],words[j])){
                   if (dp[j]+1>dp[i]){
                       dp[i] = dp[j]+1;
                       pt[i] = j;
                       if (longestSub<dp[i]){
                           longestSub= dp[i];
                           longestSubIdx=i;
                       }
                   }
               }
           }
        }

        while (longestSubIdx != -1){
            ans.add(words[longestSubIdx]);
            longestSubIdx = pt[longestSubIdx];
        }
        Collections.reverse(ans);
        return ans;
    }

    public static boolean HammingOne(String s1,String s2){
        int cnt = 0;
        for (int i = 0;i<s1.length();i++){
            if (s1.charAt(i) != s2.charAt(i)){
                cnt++;
            }
            if (cnt>1){
                return false;
            }
        }
        return true;
    }
}
