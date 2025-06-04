package Maths;

import java.util.ArrayList;
import java.util.List;

public class leetcode_1492 {
    public static void main(String[] args) {
        System.out.println(kth(4,2));
    }
    public static int kth(int n,int k){
        List<Integer> list = new ArrayList<>();
        for(int i = 1;i<=n;i++){
            if(n%i==0){
                list.add(i);
            }
            if(list.size()==k){
                return list.get(k-1);
            }
        }
        return -1;
    }

    public static int kth1(int n, int k){
        for(int i = 1;i<=n;i++){
            if(n%i==0){
                k--;
            }
            if(k==0){
                return i;
            }
        }
        return -1;
    }
}
