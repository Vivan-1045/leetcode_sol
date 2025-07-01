package DP;

import java.util.HashMap;
import java.util.Map;

public class leetode_397 {

    static Map<Long,Integer> mp = new HashMap<>();
    public static void main(String[] args) {
        System.out.println(minOpr(1000));

    }
    public static int minOpr(int n){
        return solve((long) n);
    }

    public static int solve(long n){
        if (n==1){
            return 0;
        }
        if (mp.containsKey(n)){
            return mp.get(n);
        }
        int val = 0;
        if (n%2 == 0){
            val = 1+ solve(n/2);
        }
        if (n%2 != 0){
            val = 1+ Math.min(solve(n+1),solve(n-1));

        }
        mp.put(n,val);
        return val;
    }


}
