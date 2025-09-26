package Sliding_window;

import java.util.Arrays;

public class leetcode_424 {
    public int characterReplacement(String s, int k) {
        return replaceChar(s,k);
    }

    //TLE
    int rplaceChar(String s,int k){
        int l = 0,r=0;
        int n = s.length();
        int ans = Integer.MIN_VALUE;

        while(r<n){
            int[] fr = new int[26];
            for(int i = l;i<=r;i++){
                fr[s.charAt(i)-'A']++;
            }

            Arrays.sort(fr);
            int opr = 0;

            for(int j = 0;j<25;j++){
                if(fr[j]!=0){
                    opr += fr[j];
                }
            }



            if(opr>k){
                l++;
            }
            ans = Math.max(ans,r-l+1);
            r++;
        }

        return ans;
    }

    //optimised with sliding window
    int replaceChar(String s,int k){
        int l=0,r=0;
        int maxFreq = 0;
        int n = s.length();
        int[] freq = new int[26];
        int ans = Integer.MIN_VALUE;

        while(r<n){
            freq[s.charAt(r)-'A']++;
            maxFreq = Math.max(maxFreq,freq[s.charAt(r)-'A']);

            if((r-l+1)-maxFreq > k){
                freq[s.charAt(l)-'A']--;
                l++;
            }

            ans = Math.max(ans,r-l+1);
            r++;
        }

        return ans;
    }
}
