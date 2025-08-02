package unCategorisedCode;

import java.util.Arrays;

public class leetcode_1400 {
    public static void main(String[] args) {
        String s = "annabelle";
        int k = 1;

        System.out.println(CanConstruct(s, k));
    }
    public static boolean CanConstruct(String s, int k){
        if (s.length()<k){
            return false;
        }
        int []arr = new int[26];
        Arrays.fill(arr, 0);

        for (int i =0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }
        //Number of palindrome is depend on number of Characters that occurred odd time
        int oddCount = 0;
        for (int freq: arr) {
           if (freq >= 1 && freq%2!=0){
               oddCount+=1;
           }
        }
        return oddCount<=k?true:false;
    }
}
