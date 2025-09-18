package Stack;

import java.util.Stack;

public class leetcode_32 {
    public static void main(String[] args) {
        String s = "()(()";
        System.out.println(maxLength(s));
    }
    public static int maxLength(String s){
        int ans = Integer.MIN_VALUE;
        if(s.length()==0 || s.length()==1){
            return 0;
        }

        Stack<Integer> st = new Stack<>();
        st.push(-1);

        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)==')' && st.isEmpty()){
                continue;
            }
            else if(s.charAt(i)=='('){
                st.push(i);
            }
            else{
                st.pop();
                if(st.isEmpty()){
                    st.push(i);
                }
            }
            ans = Math.max(ans,i-st.peek());
        }

        return ans;
    }
}
