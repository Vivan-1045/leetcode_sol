package Bit_Manipulation;

import java.util.Arrays;

public class leetcode_869 {
    public static void main(String[] args) {

    }
    public static boolean reOrderPowerOf2(int n){
        String s = getDigitCount(n);

        for(int i = 0;i<32;i++){
            int power2 = 1<<i;
            if(getDigitCount(power2).equals(s)){
                return true;
            }
        }

        return false;
    }

    public static String getDigitCount(int n){
        char [] st = String.valueOf(n).toCharArray();
        Arrays.sort(st);
        return new String(st);
    }
}
