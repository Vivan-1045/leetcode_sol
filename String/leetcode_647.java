package String;

public class leetcode_647 {
    public static void main(String[] args) {
        String s = "abcba";
        System.out.println(validPalindromeCount(s));
    }
    public static int validPalindromeCount(String s){
        int count = 0;
        for (int i = 0;i<s.length();i++){
            for (int j = i;j<s.length();j++){
                if (checkPalindrome(s,i,j)){
                    count +=1;
                }
            }
        }
        return count;
    }

    public static boolean checkPalindrome(String substring,int l,int r) {
        if (l==r){
            return true;
        }
        while (l<=r){
            if (substring.charAt(l) != substring.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}
