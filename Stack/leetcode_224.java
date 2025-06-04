package Stack;
import java.util.Stack;
public class leetcode_224 {
    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(basicCal(s));
    }
    public static int basicCal(String s){
        Stack<Integer> st = new Stack<>();
        int num = 0;
        int res = 0;
        int sign = 1;

        for (char ch : s.toCharArray()){
            if (Character.isDigit(ch)){
               num = (num*10) + (ch-'0');
            } else if (ch=='+') {
               res += num*sign;
               num = 0;
               sign = 1;
            } else if (ch=='-') {
               res += num*sign;
               num = 0;
               sign = -1;
            } else if (ch=='(') {
                st.push(res);
                st.push(sign);
                res = 0;
                num = 0;
                sign = 1;
            } else if (ch==')') {
                res += num*sign;
                num = 0;

                int last_sign = st.peek();
                st.pop();
                int last_res = st.peek();
                st.pop();

                res *= last_sign;
                res += last_res;
            }
        }
        res += num*sign;  // To add last digit of string. like "2+1-2"
        return res;
    }
}
