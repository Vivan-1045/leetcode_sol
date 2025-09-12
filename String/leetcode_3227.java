package String;

public class leetcode_3227 {
    public static void main(String[] args) {

    }
    boolean doesAlice(String s){
        int cnt = 0;
        for(char c : s.toCharArray()){
            if(isVowel(c)){
                cnt++;
            }
        }

        if(cnt==0){
            return false;
        }

        return true;
    }

    boolean isVowel(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }
}
