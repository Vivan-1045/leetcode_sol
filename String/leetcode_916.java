package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_916 {
    public static void main(String[] args) {
     String []words1 = {"amazon","apple","facebook","google","leetcode"};
     String []words2 = {"l","e"};
        System.out.println(wordSubsets(words1,words2));
    }
    public static List<String> wordSubsets(String []words1, String[] words2){
        int [] arr = new int[26];
        Arrays.fill(arr,0);

        for (String ch : words2){
            int [] tempArr = new int[26];
            for (int i = 0;i<ch.length();i++){
                tempArr[ch.charAt(i)-'a']++;
            }
            for (int j = 0;j<26;j++){
                arr[j] = Math.max(arr[j],tempArr[j]);
            }
        }


        List<String> list = new ArrayList<>();
        for (String ch : words1){
            int [] tempArr1 = new int[26];
            for (int i = 0;i<ch.length();i++){
                tempArr1[ch.charAt(i)-'a']++;
            }
            boolean isValid = true;
            for (int i = 0; i < 26; i++) {
                if (arr[i] > tempArr1[i]) {
                    isValid = false;
                    break;
                }
            }
            if(isValid){
                list.add(ch);
            }
        }
        return list;

    }
}
