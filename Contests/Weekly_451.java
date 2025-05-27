package Contests;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Weekly_451 {

    public static void main(String[] args) {
       Map<String,String> mp = new HashMap<>();
    }
    public static String stringAfterOpr(String s) {
        Deque<Character> st = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (!st.isEmpty() && isConsecutive(st.peekLast(), ch)) {
                st.pollLast();
            } else {
                st.addLast(ch);
            }
        }

        StringBuilder result = new StringBuilder();
        for (char ch : st) {
            result.append(ch);
        }

        return result.toString();
    }

    public static boolean isConsecutive(char c1, char c2) {
        int diff = Math.abs(c1 - c2);
        return diff == 1 || diff == 25;
    }

    public static String dfs(String s, Map<String, String> mp) {
        if (mp.containsKey(s)) return mp.get(s);

        String minStr = s;

        for (int i = 0; i < s.length() - 1; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);

            if (isConsecutive(c1, c2)) {

                String newStr = s.substring(0, i) + s.substring(i + 2);
                String newStr1 = dfs(newStr, mp);
                if (newStr1.compareTo(minStr) < 0) {
                    minStr = newStr1;
                }
            }
        }

        mp.put(s, minStr);
        return minStr;
    }
}
