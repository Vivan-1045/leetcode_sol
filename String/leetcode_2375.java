package String;

import java.util.Stack;

public class leetcode_2375 {
    public static void main(String[] args) {
        String pattern = "IIIDIDDD";
        System.out.println(lexoSmallString(pattern));
    }
    public static String lexoSmallString(String pattern){
        StringBuilder ans = new StringBuilder();
        Stack<String> stk = new Stack<>();
        for (int i  =1;i<=pattern.length()+1;i++){
            stk.push(i +"");
            if ( i>pattern.length()|| pattern.charAt(i-1) == 'I'){
                while (!stk.isEmpty()){
                    ans.append(stk.pop());
                }
            }
        }
        return ans.toString();
    }
}
