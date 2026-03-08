package Hard;

public class leetcode_214 {
    public String shortestPalindrome(String s) {
        return solve1(s);
    }

    //TLE 121/126
    String solve(String s){
        int n = s.length();

        if(isPalind(s)){
            return s;
        }

        for(int i =n;i>0;i--){
            StringBuilder sub = new StringBuilder(s.substring(i-1,n));
            String rev = sub.reverse().toString();
            if(isPalind(rev+s)){
                return rev+s;
            }
        }

        return "";
    }

    //Slightly optimised
    String solve1(String s){
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();

        for(int i = 0;i<n;i++){
            if(s.substring(0,n-i).equals(sb.toString().substring(i))){
                return sb.toString().substring(0,i)+s;
            }
        }

        return sb.toString()+s;
    }

    boolean isPalind(String s){
        int i = 0;
        int n = s.length();

        while(i<n/2){
            if(s.charAt(i) != s.charAt(n-i-1)){
                return false;
            }
            i++;
        }
        return true;
    }
}
