package Maths;

import java.util.*;

public class leetcode_386 {
    public static void main(String[] args) {
//        System.out.println(ans(13));
    }
    public static List<Integer> ans(int n){
        List<Integer> res = new ArrayList<>();
        for (int i = 1;i<=n;i++){
            res.add(i);
        }
//        Collections.sort(res,(a,b)->String.valueOf(a).compareTo(String.valueOf(b)));
        res.sort(Comparator.comparing(String::valueOf));
        return res;
    }


}
