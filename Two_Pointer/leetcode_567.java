package Two_Pointer;

import java.util.*;

public class leetcode_567 {
    public static void main(String[] args) {

    }

    //Simple brute force
    public static boolean ifExist(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        for(int i =0;i<m;i++){
            if(i+n>m){
                return false;
            }

            Map<Character,Integer> mp= new HashMap<>();
            for(char ch : s1.toCharArray()){
                mp.put(ch,mp.getOrDefault(ch,0)+1);
            }

            int j =0;
            String s = s2.substring(i,i+n);
            while(j<s.length()){
                if(mp.containsKey(s.charAt(j))){
                    mp.put(s.charAt(j),mp.get(s.charAt(j))-1);

                    if(mp.get(s.charAt(j))==0){
                        mp.remove(s.charAt(j));
                    }
                }else{
                    break;
                }
                j++;
            }

            if(mp.size()==0){
                return true;
            }
        }

        return false;
    }


    //optimised way
    public static boolean solve(String s1, String s2){
        int n = s1.length();
        int m = s2.length();

        if(n>m){
            return false;
        }

        char[] ch1 = new char[26];
        char[] ch2 = new char[26];

        for(int i = 0;i<n;i++){
            ch1[s1.charAt(i)-'a']++;
            ch2[s2.charAt(i)-'a']++;
        }

        for(int i = n;i<m;i++){
            if(Arrays.equals(ch1,ch2)){
                return true;
            }

            ch2[s2.charAt(i)-'a']++;
            ch2[s2.charAt(i-n)-'a']--;
        }

        return Arrays.equals(ch1,ch2);

    }
}
