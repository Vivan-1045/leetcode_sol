package Backtracking;

import java.util.Arrays;

public class leetcode_1718 {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(Arrays.toString(getLxoLargest(n)));
    }
    public static int[] getLxoLargest(int n){
        int []res = new int[n*2-1];
        Arrays.fill(res,-1);
        boolean []used = new boolean[n+1];
        checkIdx(res,used,0,n);

        return res;

    }
    public static boolean checkIdx(int[] res , boolean[] used , int i, int n){
        //Base conditions
        if (i>=res.length){
            return true;
        }

        //it means current idx is filled check for next
        if (res[i] != -1){
            return checkIdx(res,used,i+1,n);
        }

        for(int num = n;num>=1;num--){
            //Number is Already used
            if (used[num]){
                continue;
            }

            //try
            used[num] = true;
            res[i] = num;

            //Explore further

            //If number is exactly 1 then store it at the current idx no need to find jth idx
            //And move further
            if (num==1){
                if (checkIdx(res,used,i+1,n)){
                    return true;
                }
            //otherwise find jth idx and store that number at jth idx
            //And move further
            }else {
                int j = i+ res[i];
                if (j<res.length&& res[j]==-1){
                    res[j] = num;
                    if (checkIdx(res,used,i+1,n)){
                        return true;
                    }
                    res[j] = -1;
                }
            }

            used[num] =false;
            res[i] =-1;
        }
        return false;
    }
}
