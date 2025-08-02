package unCategorisedCode;

public class leetcode_680 {
    public static void main(String[] args) {
        String s  = "abca";
        boolean ans = palindrome(s);
        System.out.println(ans);
    }
    public static boolean palindrome(String s){
        int l = 0;
        int r = s.length()-1;
        while (l<r){
            if (s.charAt(l) != s.charAt(r)){
                // check if by excluding one left side element or excluding one right side element it become palindrome or not
               return Ispalindrome(s, l+1, r) || Ispalindrome(s, l, r-1);
            }
           l++;
            r--;
        }
        return true;
    }
    public static boolean Ispalindrome(String s, int l , int r){
        while (l<r){
            if (s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
