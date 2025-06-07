package Stack;
import java.util.Stack;
public class leetcode_2434 {
    public static void main(String[] args) {
        System.out.println(lexoSmallestString("adcfbe"));
    }
    public static String lexoSmallestString(String s){
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();


        for (int i = 0;i<s.length();i++){
            st.push(s.charAt(i));
            char minChar = Character.MAX_VALUE;
            for (int j = i+1;j<s.length();j++){
                minChar = (char) Math.min(s.charAt(j),minChar);
            }
            while (!st.isEmpty() && st.peek()<=minChar){
                ans.append(st.pop());
            }
        }
        while (!st.isEmpty()){
            ans.append(st.pop());
        }
        return ans.toString();
    }
    //optimal
    public static String getLexoSmall(String s){
        Stack<Character> st = new Stack<>();
        int n = s.length();
        StringBuilder ans = new StringBuilder();
        char [] minChar = new char[n+1];
        minChar[n] = Character.MAX_VALUE;

        for (int i=n-1;i>=0;i--){
            minChar[i] = (char) Math.min(s.charAt(i),minChar[i+1]);
        }

        for (int i = 0;i<n;i++){
            st.push(s.charAt(i));
            while (!st.isEmpty() && st.peek()<=minChar[i+1]){
                ans.append(st.pop());
            }
        }
        while (!st.isEmpty()){
            ans.append(st.pop());
        }
        return ans.toString();
    }
}
