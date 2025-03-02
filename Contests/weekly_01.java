package Contests;

import java.util.Arrays;

public class weekly_01 {
    public static void main(String[] args){
        String s = "abcabcab";
        System.out.println(maxDiff(s));
    }
    public static int maxDiff(String s){
        int []freq = new int[26];
        for (char ch : s.toCharArray()){
            freq[ch-'a']++;
        }

        int mineven = Integer.MAX_VALUE;
        int maxodd = Integer.MIN_VALUE;

        for(int n : freq){
            if (n%2 == 0 && n>0){
                mineven = Math.min(n,mineven);
            }
            if(n%2 !=0 ){
                maxodd = Math.max(n,maxodd);
            }
        }
        if(mineven != Integer.MAX_VALUE && maxodd != Integer.MIN_VALUE){
            return maxodd-mineven;
        }

        return 0;
    }
}
