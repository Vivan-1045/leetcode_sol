package Contests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class weekly_459 {

    public boolean checkDivisibility(int n) {
        return isDivisible(n);
    }
    boolean isDivisible(int n){
        int sum = findSum(n);
        int prod = findprod(n);

        if(n%(sum+prod)==0){
            return true;
        }
        return false;
    }

    int findSum(int n){
        int digitSum = 0;
        while(n>0){
            digitSum += n%10;
            n =n/10;
        }
        return digitSum;
    }


    int findprod(int n){
        int digitProd = 1;
        while(n>0){
            digitProd *= n%10;
            n =n/10;
        }
        return digitProd;
    }


    public int countHorizontalTrapezoids(int[][] points) {
        final int MOD = 1_000_000_007;

        Map<Integer, List<Integer>> yMap = new HashMap<>();
        for (int[] point : points) {
            int x = point[0], y = point[1];
            yMap.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
        }

        List<Long> allSegments = new ArrayList<>();
        for (List<Integer> xs : yMap.values()) {
            if ( xs.size() >= 2) {
                long segCount = ((long)  xs.size() * ( xs.size() - 1)) / 2;
                allSegments.add(segCount);
            }
        }

        long ans = 0;
        long sumOfSquares = 0;

        for (long seg : allSegments) {
            ans = (ans + seg) % MOD;
            sumOfSquares = (sumOfSquares + seg * seg % MOD) % MOD;
        }



        long res = (ans * ans % MOD - sumOfSquares + MOD) % MOD;
        res = res * modInverse() % MOD;

        return (int) res;
    }

    long modInverse() {
        return powMod(2, 1000000007 - 2);
    }

    long powMod(long base, long exp) {
        long res = 1;
        base %= 1000000007;
        while (exp > 0) {
            if ((exp & 1) == 1) res = res * base % 1000000007;
            base = base * base % 1000000007;
            exp >>= 1;
        }
        return res;
    }
}
