package unCategorisedCode;

import java.util.Arrays;

public class leetcode_3223 {
    public static void main(String[] args) {
        String s = "bb";
        System.out.println(MaxLength(s));
    }
    public static int MaxLength(String s){
        if (s.length()<3){
            return s.length();
        }
        int []freq = new int[26];
        Arrays.fill(freq, 0);
        int length = 0;

        for (int i =0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        for (int i = 0; i <26; i++) {
            if (freq[i]<3){
                length += freq[i];
            } else if (freq[i]>=1 && freq[i]%2 ==0) {
                length += 2;
            }else{
                length += 1;
            }
        }
        return length;
    }
}
