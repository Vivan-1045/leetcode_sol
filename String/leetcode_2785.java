package String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class leetcode_2785 {
    public static void main(String[] args) {

    }
    public static String sortedVowel(String s){
        List<Character> vowel = new ArrayList<>();

        for(char ch : s.toCharArray()){
            if(isVowel(ch)){
                vowel.add(ch);
            }
        }

        Collections.sort(vowel);
        String ans = "";
        int j = 0;
        for(int i = 0;i<s.length();i++){
            if(isVowel(s.charAt(i))){
                ans += vowel.get(j++);
            }else{
                ans += s.charAt(i);}
        }

        return ans;
    }

    public static boolean isVowel(char c){
        return c=='A'||c=='E'||c=='O'||c=='I'||c=='U'||c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }
}
