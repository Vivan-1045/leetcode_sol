package unCategorisedCode;

public class leetcode_1790 {
    public static void main(String[] args) {
        String s1 = "bank";
        String s2 = "kanb";
        System.out.println(isValid(s1,s2));
    }
    public static boolean isEqual(String s1, String s2){
        int count  = 0;
        int []freq1 = new int[26];
        int []freq2 = new int[26];

        for (int i =0;i<s1.length();i++){
            if (s1.charAt(i) != s2.charAt(i)){
                count+=1;
            }
            if (count>2){
                return false;
            }
            freq1[s1.charAt(i)-'a']++;
            freq2[s2.charAt(i)-'a']++;
        }
        for (int i =0;i<26;i++){
            if (freq1[i] != freq2[i]){
                return false;
            }
        }
        return true;
    }


    //optimised way
    public static boolean isValid(String s1, String s2){
        int count = 0;
        int idx1 =  0;
        int idx2 = 0;
        for (int i =0;i<s1.length();i++){
            if (s1.charAt(i)!=s2.charAt(i)){
                count++;
                if (count>2){
                    return false;
                } else if (count == 1) {
                    idx1 = i;
                }else {
                    idx2 = i;
                }
            }
        }

        return  s1.charAt(idx1)==s2.charAt(idx2) && s1.charAt(idx2)==s2.charAt(idx1);
    }
}
