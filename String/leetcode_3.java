package String;
import java.util.HashSet;
import java.util.Set;

public class leetcode_3 {
    public static void main(String[] args) {
        String s = " ";
        System.out.println(maxLengthSubstring(s));
    }

    //Brute force approach 686/687 pass
    public static int maxLength(String s){
        int n = s.length();
        if (n==0){
            return 0;
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0;i<n;i++){
            int k = i;
            for (int j = k;j<n;j++){
                if (check(s.substring(k,j+1))){
                    ans = Math.max(ans,(s.substring(k,j+1)).length());
                }
                else{
                    k = j;
                }
            }
        }
        return ans;
    }
    public static boolean check(String s){
        Set<Character> st = new HashSet<>();
        for (char ch : s.toCharArray()){
            if (!st.add(ch)){
                return false; //duplicate found
            }
        }
        return true;
    }

    //Sliding window approach
    public static int maxLengthSubstring(String s){
        Set<Character> st = new HashSet<>();
        int i = 0,j=0,n= s.length(),ans = 0;

        while (j<n){
            if (!st.contains(s.charAt(j))){
                st.add(s.charAt(j));
                ans = Math.max(ans,j-i+1);
                j++;
            }else{
                st.remove(s.charAt(i));
                i++;
            }
        }

        return ans;
    }

}
