package Stack;

import java.util.Stack;

public class leetcode_921 {
    public static void main(String[] args) {
        String s = "()))((";
        System.out.println(totalMove(s));
    }
    public static int totalMove(String s){
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()){
            if (!st.isEmpty() && getMatch(st.peek(),ch)){
                st.pop();
            }
            else{
                st.push(ch);
            }
        }

        return st.size();
    }

    public static boolean getMatch(char ch1 , char ch2){
        if (ch2 ==')' && ch1=='('){
            return true;
        }
        return false;
    }
}
