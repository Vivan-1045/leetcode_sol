package DP;

import java.util.Objects;

public class leetcode_2311 {
    public static void main(String[] args) {
        String s = "0";
        System.out.println(maxLength(s,583196182));
    }
    public static int maxLength(String s,int k){
        int length = 0;
        for (int i = 0;i<s.length();i++){
            if (s.charAt(i)=='0'){
                length++;
            }
        }

        long val = 0;
        int totalUsedBit = 0;

        for (int i = s.length()-1;i>=0 && totalUsedBit<31;i--){
            if (s.charAt(i)=='1'){
                long currVal = val + (1L<<totalUsedBit);
                if (currVal<=k){
                    length++;
                    val = currVal;
                }
                totalUsedBit++;
            } else {
                totalUsedBit++;
            }
        }
        return length;
    }
}
