package unCategorisedCode;

import java.util.Stack;

public class leetcode_1910 {
    public static void main(String[] args) {
      String s = "daabcbaabcbc";
      String part = "abc";
      System.out.println(remainOccuranceString(s,part));
      System.out.println(remainString(s,part));
    }

    //Using StringBuilder
    public static String remainString(String s, String part){
        StringBuilder sb = new StringBuilder(s);

        while (sb.indexOf(part) != -1){
            int n = sb.indexOf(part);
            sb.delete(n,part.length()+n);
        }
        return sb.toString();
    }


    //Using Stack
    public static boolean checkPattern(int n ,Stack<Character> stk ,String part){
        Stack<Character> stk1 = (Stack<Character>) stk.clone();
        for (int i =n-1;i>=0;i--){
            if (stk1.isEmpty()||stk1.peek() != part.charAt(i)){
                return false;
            }
            stk1.pop();
        }
        return true;
    }
    public static String remainOccuranceString(String s, String part){
        int n = part.length();
        Stack<Character> stk = new Stack<>();
        for (int i =0;i<s.length();i++){
            stk.push(s.charAt(i));
            if (stk.size()>= part.length() && checkPattern(n, stk, part)){
                for (int j = n-1;j>=0;j--){
                    stk.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()){
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }
}
