package Maths;

import java.util.HashMap;
import java.util.Map;

public class leetcode_2579 {
    public static Map<Integer,Long> mp = new HashMap<>();
    public static void main(String[] args) {
        int n = 6;
        System.out.println(coloredCells(n));
    }
    //Approach 1
    public static long coloredCells(int n){
        if (mp.containsKey(n)){
            return mp.get(n);
        }
        if (n==1){
            return 1 ;
        }else {
            long res = coloredCells(n-1) + (n-1)* 4L;
            mp.put(n, (long) res);
            return res;
        }
    }

    // Approach 2
    public static  long totalCells(int n){
        long res = 1;
        for(int i = 2;i<=n;i++){
            res += (i-1)*4L;
        }
        return res;
    }

    // final Approach
    public static long totalCell(int n){
        return 1 + (long)2*n*(n-1);
    }

}
