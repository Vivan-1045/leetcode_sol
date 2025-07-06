package Contests;

import java.io.CharConversionException;
import java.util.*;

public class weekly_457 {
    public static void main(String[] args) {
        System.out.println(minimumMoves(0,0,0,0));
    }
    public static List<String> coupon(String[] code, String[] businessLine, boolean[] isActive) {
        List<String[]> valid = new ArrayList<>();
        List<String> order = Arrays.asList("electronics", "grocery", "pharmacy", "restaurant");

        for (int i = 0; i < code.length; i++) {
            if (isActive[i] &&code[i] != null &&code[i].matches("^[a-zA-Z0-9_]+$") &&order.contains(businessLine[i])) {
                valid.add(new String[]{businessLine[i], code[i]});
            }
        }

        valid.sort((a, b) -> {
            int cmp = Integer.compare(order.indexOf(a[0]), order.indexOf(b[0]));
            if (cmp != 0) return cmp;
            return a[1].compareTo(b[1]);
        });

        List<String> result = new ArrayList<>();
        for (String[] pair : valid) {
            result.add(pair[1]);
        }

        return result;
    }

    static Map<String,Integer> memo=new HashMap<>();
    public static int minimumMoves(int sx,int sy,int tx,int ty){
        return solve(sx,sy,tx,ty);
    }
    public static int solve(int sx,int sy, int tx, int ty){
        if (sx>tx|| sy>ty){
            return -1;
        }
        if (sx==tx&&sy==ty){
            return 0;
        }
        String key= sx+","+sy;
        if (memo.containsKey(key)){
            return memo.get(key);
        }

        int minx = solve(Math.max(sx,sy)+sx,sy,tx,ty);
        int miny=solve(sx,Math.max(sx,sy)+sy,tx,ty);

        int res=0;
        if (minx==-1 && miny==-1){
            res= -1;
        }
        else if (minx==-1){
            res=1+miny;
        }
        else if (miny==-1){
            res= 1+minx;
        }else{
            res = 1+ Math.min(minx,miny);
        }
        memo.put(key,res);
        return res;
    }

}
