package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_368 {
    public static void main(String[] args) {
       int[] arr = {1,2,4,8};
        System.out.println(largestDiv(arr));
    }
    public static void Solve(int idx,int[] arr, List<Integer> res,List<Integer> temp , int pre){
        if (idx>=arr.length){
            if (temp.size()>res.size()){
                res.clear();
                res.addAll(temp);
            }
            return;
        }

        if (pre==-1|| arr[idx]%pre==0){
            temp.add(arr[idx]);
            Solve(idx+1,arr,res,temp,arr[idx]);
            temp.remove(temp.size()-1);
        }
        Solve(idx+1,arr,res,temp,pre);
    }
    public static List<Integer> largestDivisible(int[] arr){
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();

        Solve(0,arr,res,list1,-1);
        return res;
    }

    public static List<Integer> largestDiv(int[] arr){
        Arrays.sort(arr);
        int n = arr.length;

        int []dp = new int[n];
        int []prev = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(prev,-1);

        int lastChosenIndex = 0;
        int maxLength =1;

        for (int i =1;i<n;i++){
            for (int j =0;j<i;j++){
                if (arr[i]%arr[j]==0){

                    if (dp[i]<dp[j]+1){
                        dp[i] = dp[j] +1;
                        prev[i]= j;
                    }

                    if (dp[i]>maxLength){
                        maxLength = dp[i];
                        lastChosenIndex = i;
                    }
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        while (lastChosenIndex !=-1){
            res.add(arr[lastChosenIndex]);
            lastChosenIndex = prev[lastChosenIndex];
        }
        return res;
    }
}
