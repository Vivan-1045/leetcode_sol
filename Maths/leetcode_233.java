package Maths;

import java.util.HashMap;
import java.util.Map;

public class leetcode_233 {
    static Map<Integer,Integer> mp = new HashMap<>();
    public static void main(String[] args) {
        System.out.println(numberOfOneS(1000000000));
    }
    public static int numberOfOne(int n){
        if (n==0){
            return 0;
        }
        int count = 0;
        for (int i = 1;i<=n;i++){
            if (mp.containsKey(i)){
                count += mp.get(i);
                continue;
            }

            int num = i;
            int ones = 0;
            while (num>0){
                if (num%10==1){
                    ones+=1;
                }
                num /= 10;
            }
            mp.put(i,ones);
            count += ones;
        }
        return count;
    }

    public static int numberOfOneS(int n) {
        int count = 0;

        for (long i = 1; i <= n; i *= 10) {
            long divider = i * 10;
            count += (int) ((n / divider) * i + Math.min(Math.max(n % divider - i + 1, 0), i));
        }

        return count;
    }

}
