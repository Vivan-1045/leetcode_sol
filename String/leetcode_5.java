package String;

public class leetcode_5 {
    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindromic(s));
    }
    
    public static String longestPalindromic(String s) {
        if (s==null || s.length()==0) return "";
        int st = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Expand around the center (odd-length palindromes)
            int len1 = expandAroundCenter(s, i, i);
            // Expand around the center (even-length palindromes)
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1,len2);

//           update the start and end pointer if length is max from previous one
            if (len >end-st){
                st = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(st,end+1);
    }

    // check palindrome around the centre character
    public static int expandAroundCenter(String s, int left, int right) {
        int n = s.length();
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // The length of the palindrome
    }

}
