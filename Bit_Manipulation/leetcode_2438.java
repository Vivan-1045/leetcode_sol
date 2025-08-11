package Bit_Manipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class leetcode_2438 {
    public static void main(String[] args) {

    }
    public static int MOD = 1_000_000_007;
    public static int [] productQueries1(int n, int[][]qeries){
        List<Integer> list = new ArrayList<>();

        String s = Integer.toBinaryString(n);

        int cnt = 0;
        for(int i = s.length()-1;i>=0;i--){
            if(s.charAt(i)=='0'){
                cnt++;
                continue;
            }else{
                list.add(1<<cnt);
                cnt++;
            }
        }

        Collections.sort(list);
        int []ans = new int[qeries.length];
        int i = 0;
        for(int[] query : qeries){
            int l = query[0];
            int r = query[1];
            ans[i++] = getProd(list,l,r);
        }

        return ans;
    }

    public static int getProd(List<Integer> list, int s, int e){
        int prod = 1;
        while(s<=e){
            prod = (int)((1L*prod%MOD * list.get(s))%MOD);
            s++;
        }
        return prod;
    }
}
