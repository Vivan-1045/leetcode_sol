package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class leetcode_3561 {
    public static void main(String[] args) {

        String s = "zadb";
        System.out.println(stringAfterOpr(s));
    }
    public static String stringAfterOpr(String s){
        Deque<Character> st = new ArrayDeque<>();

        for (char ch : s.toCharArray()){
            if (!st.isEmpty() && isConsucative(ch,st.peekLast())){
                st.pollLast();
            }else{
                st.addLast(ch);
            }
        }

        StringBuilder ans = new StringBuilder();
        for (char ch1 : st){
            ans.append(ch1);
        }

        return ans.toString();
    }

    public static boolean isConsucative(char c1, char c2){
        int diff = Math.abs(c1-c2);
        return diff==1||diff==25;
    }
}
