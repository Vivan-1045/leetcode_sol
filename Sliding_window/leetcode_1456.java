package Sliding_window;

public class leetcode_1456 {
    public static void main(String[] args) {
        System.out.println(maxVowelCount("aeiou",3));
    }

    public static int maxVowelCount(String s, int k){
        int ans = 0;
        int n = s.length();
        int i = 0;
        int j = 0,vowelCount = 0;

        while(j<n){
            if(isVowel(s.charAt(j))){
                vowelCount++;
            }
            if(j-i+1<k){
                j++;
                continue;
            }
            if(j-i+1==k){
                ans = Math.max(ans,vowelCount);
                if(isVowel(s.charAt(i))){
                    vowelCount--;
                }
                i++;
                j++;
            }
        }

        return ans;
    }

    public static boolean isVowel(char ch){
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
    }
}
