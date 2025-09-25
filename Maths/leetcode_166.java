package Maths;

import java.util.HashMap;
import java.util.Map;

public class leetcode_166 {
    public String fractionToDecimal(int numerator, int denominator) {
        return fractional(numerator,denominator);
    }

    String fractional(int num,int deno){
        if(num==0){
            return "0";
        }
        StringBuilder ans = new StringBuilder();

        if((long)num*(long)deno < 0){
            ans.append("-");
        }

        long absNum = Math.abs((long)num);
        long absDeno = Math.abs((long)deno);

        long digit = absNum/absDeno;
        ans.append(digit);
        long remain = absNum % absDeno;
        if(remain==0){
            return ans.toString();
        }

        ans.append(".");

        Map<Long,Integer> mp = new HashMap<>();

        while(remain !=0){
            if(mp.containsKey(remain)){
                ans.insert(mp.get(remain),"(");
                ans.append(")");
                break;
            }

            mp.put(remain,ans.length());

            remain *= 10;
            ans.append(remain/absDeno);

            remain = remain%absDeno;
        }

        return ans.toString();
    }
}
