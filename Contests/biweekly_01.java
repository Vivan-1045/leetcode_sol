package Contests;

import java.util.Arrays;

public class biweekly_01 {
    public static void main(String[] args) {
        String s = "221";
        System.out.println(ValidPair(s));
    }
    public static String ValidPair(String s) {
        int[] freq = new int[10];

        for (int n : s.toCharArray()) {
            int idx = n-'0';
            freq[idx]++;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            int firstDigit = s.charAt(i) - '0';
            int secondDigit = s.charAt(i + 1) - '0';

            if (firstDigit != secondDigit &&
                    freq[firstDigit] == firstDigit &&
                    freq[secondDigit] == secondDigit) {
                return s.substring(i, i + 2);
            }
        }
        return "";
    }
}
