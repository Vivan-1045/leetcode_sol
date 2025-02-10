import java.util.Stack;

public class leetcode_3174 {
    public static void main(String[] args) {
        String s = "23de";
        System.out.println(remainString(s));
    }
    public static String remainString(String s){
        Stack<Character> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()){
            if (stk.size()>0 && Character.isDigit(ch)){
                stk.pop();
            }else {
                stk.push(ch);
            }
        }
        while (!stk.isEmpty()){
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }
}
