package Contests;

import java.util.HashMap;
import java.util.Map;

public class biweekly_153 {

    public static void main(String[] args) {
       String s = "zaza";
        System.out.println(reverseVal(s));
    }
    public static int reverseVal(String st) {
        String s = "abcdefghijklmnopqrstuvwxyz";
        Map<Character, Integer> mp = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int val = 26 - i;
            mp.put(s.charAt(i), val);
        }

        int ans = 0;

        for (int i = 0; i < st.length(); i++) {
            int reverseVal = mp.get(st.charAt(i));

            ans += reverseVal * (i + 1);
        }

        return ans;
    }


}
