package String;

public class leetcode_3675 {
    public int minOperations(String s) {
        return minOpr(s);
    }
    int minOpr(String s){
        int[] freq = new int[26];

        for(char ch : s.toCharArray()){
            if(ch != 'a'){
                freq[ch-'a']++;
            }
        }

        for(int i = 0;i<26;i++){
            if(freq[i] != 0){
                return (122 - (97 + i)) + 1;
            }
        }

        return 0;
    }
}
