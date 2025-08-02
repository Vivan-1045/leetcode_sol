package unCategorisedCode;

import java.util.HashSet;
import java.util.Set;

public class leetcode_1930 {
    public static void main(String[] args) {
    String s = "aabca";
        System.out.println(validPalin(s));
    }
    public static int validPalin(String s){
        Set<Character> st = new HashSet<>();
        for (int i =0;i<s.length();i++){
            st.add(s.charAt(i));
        }
        int res = 0;

        for (char ch: st) {
            int left_idx = -1;
            int right_idx = -1;
            for (int j = 0;j<s.length();j++){
                if (ch==s.charAt(j)){
                    if (left_idx==-1){
                        left_idx = j;
                    }
                    right_idx = j;
                }
            }

                Set<Character> st1 = new HashSet<>();
                for (int m = left_idx+1; m <= right_idx-1; m++) {
                    st1.add(s.charAt(m));
                }
                res += st1.size();

        }
        return res;
    }
}
