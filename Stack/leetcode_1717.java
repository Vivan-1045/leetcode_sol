package Stack;

import java.util.Stack;

public class leetcode_1717 {
    public static void main(String[] args) {
        String s = "cdbcbbaaabab";
        System.out.println(maxScore(s,4,5));
    }
    static int score = 0;
    public static int maxScore(String s,int x, int y){
        if(x>=y){
            String s1 = getX(s,x);
            getY(s1,y);
        }else{
            String s2 = getY(s,y);
            getX(s2,x);
        }

        return score;
    }

    public static String getX(String s, int x){
        Stack<Character> st = new Stack<>();

        for(int i = 0;i<s.length();i++){
            if(!st.isEmpty() && s.charAt(i)=='b'&&st.peek()=='a'){
                st.pop();
                score +=x;
            }else{
                st.push(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();

        return sb.toString();
    }

    public static String getY(String s, int y){
        Stack<Character> st = new Stack<>();

        for(int i = 0;i<s.length();i++){
            if(!st.isEmpty() && s.charAt(i)=='a'&&st.peek()=='b'){
                st.pop();
                score +=y;
            }else{
                st.push(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();

        return sb.toString();
    }
}
