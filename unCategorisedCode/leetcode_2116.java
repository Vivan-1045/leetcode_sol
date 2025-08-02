package unCategorisedCode;

public class leetcode_2116 {
    public static void main(String[] args) {
        String s = "))()))";
        String l = "010100";
        System.out.println(isValidParenthesis(s, l));
    }

    public static boolean isValidParenthesis(String s,String locked){
        if (s.length()%2 !=0){
            return false;
        }
        //traverse from right to left
        int openBraces =0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='(' || locked.charAt(i)=='0'){
                openBraces++;
            }else{
                openBraces--;
            }
            if (openBraces<0){
                return false;
            }
        }

        //traverse from left to right
        int closeBraces =0;
        for (int i = s.length()-1; i >=0; i--) {
            if (s.charAt(i)==')' || locked.charAt(i)=='0'){
                closeBraces++;
            }else{
                closeBraces--;
            }
            if (closeBraces<0){
                return false;
            }
        }
        return true;
    }
}
