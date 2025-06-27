package Sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode_30 {
    public static void main(String[] args) {
        String[] s = {"fooo", "barr", "wing", "ding", "wing"};
        String st = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        System.out.println(subStringIndices(st, s));
    }

    //Getting TLE 181/182
    public static List<Integer> indices(String s, String[] word) {
        List<Integer> ans = new ArrayList<>();

        int len = word[0].length() * word.length;

        for (int i = 0; i <= s.length() - len; i++) {
            Map<String, Integer> mp = new HashMap<>();
            if (len + i > s.length()) {
                break;
            }
            int k = i;
            for (String w : word) {
                mp.put(w, mp.getOrDefault(w, 0) + 1);
            }

            while (k < len + i) {
                String sub = s.substring(k, k + word[0].length());
                if (!mp.containsKey(sub)) {
                    break;
                }

                mp.put(sub, mp.get(sub) - 1);
                if (mp.get(sub) == 0) {
                    mp.remove(sub);
                }
                k += word[0].length();
            }
            if (mp.isEmpty()) {
                ans.add(i);
            }
        }

        return ans;
    }


    //Optimise the above solution
    public static List<Integer> subStringIndices(String s, String[] word) {
        Map<String, Integer> freqMap = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        int wordLen = word[0].length();

        for (String w : word) {
            freqMap.put(w, freqMap.getOrDefault(w, 0) + 1);
        }

        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i, count = 0;
            Map<String, Integer> window = new HashMap<>();

            while (right + wordLen <= s.length()) {
                String word1 = s.substring(right, right + wordLen);
                right += wordLen;

                if (!freqMap.containsKey(word1)) {
                    window.clear();
                    count = 0;
                    left = right;
                    continue;
                }

                window.put(word1, window.getOrDefault(word1, 0) + 1);
                count++;

                while (window.get(word1) > freqMap.get(word1)) {
                    String leftWord = s.substring(left, left + wordLen);
                    window.put(leftWord, window.get(leftWord) - 1);
                    count--;
                    left += wordLen;
                }

                if (count == word.length) {
                    ans.add(left);
                }
            }

        }
        return ans;
    }

}
