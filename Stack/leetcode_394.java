package Stack;

import java.util.Stack;

public class leetcode_394 {
    public static void main(String[] args) {
       String s = "3[a2[c]]";
        System.out.println(decodedString(s));
    }
    public static String decodedString(String s){
        Stack<Integer> numStack = new Stack<>();
        Stack<String> stStack = new Stack<>();

        int k = 0;
        String str = "";
        for (char ch : s.toCharArray()){
            if (Character.isDigit(ch)){
                k = (k*10) + (ch-'0');
            } else if (ch == '[') {
                numStack.push(k);
                stStack.push(str);
                k = 0;
                str = "";
            }
            else if(ch==']'){
                int repeatTime = numStack.pop();
                String prev = stStack.pop();
                str = prev + str.repeat(repeatTime);
            }else{
                str += ch;
            }
        }
        return str;
    }

}
