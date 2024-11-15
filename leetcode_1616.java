import java.util.Arrays;

public class leetcode_1616 {
    public static void main(String[] args) {
        String a = "ulacfd";
        String b = "jizalu";
        if(a.length()==1){
            System.out.println(true);
        }
        System.out.println(checkPalindrome(a, b));

    }
    public static boolean checkPalindrome(String a, String b){
        return checkPalin(a,b)||checkPalin(b,a);
    }
    private static boolean checkPalin(String a , String b){
        int  i =0;
        int j = a.length()-1;
        while (i<j && a.charAt(i)==b.charAt(j)){
            i++;
            j--;
        }
        return isPalindrome(a,i,j)||isPalindrome(b,i,j);
    }
    public static boolean isPalindrome(String a , int i , int j){
        while (i<j){
            if(a.charAt(i) != a.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
