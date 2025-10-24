package Backtracking;

import java.util.HashMap;
import java.util.Map;

public class leetcode_2048 {
    int[]digitFreq = {0,1,2,3,4,5,6,7,8,9};
    public int nextBeautifulNumber(int n) {
        // return nextNumber(n);
        int d = (n+"").length();
        int ans = backTrack(n,0,d);

        return ans!=0?ans:backTrack(n,0,d+1);
    }

    //Basic Brute force
    int nextNumber(int n){
        for(int i = n+1;i<=1224444;i++){
            if(isBalanced(i+"")){
                return i;
            }
        }
        return 0;
    }

    boolean isBalanced(String s){
        Map<Character,Integer> mp = new HashMap<>();

        for(char ch : s.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }

        for(char ch : s.toCharArray()){
            int val = Integer.parseInt(ch+"");
            if(mp.get(ch) != val){
                return false;
            }
        }

        return true;
    }

    //Optimal
    int backTrack(int n, int curr , int cnt){
        if(cnt==0){
            for(int i = 1;i<=9;i++){
                if(digitFreq[i] != 0 && digitFreq[i] != i){
                    return 0;
                }
            }
            return curr>n?curr:0;
        }

        int res = 0;

        for(int i = 1;i<=9;i++){
            if(digitFreq[i]>0 && digitFreq[i]<=cnt){
                digitFreq[i]--;
                res = backTrack(n,curr*10+i,cnt-1);
                digitFreq[i]++;
            }

            if(res != 0){
                break;
            }
        }

        return res;

    }
}
