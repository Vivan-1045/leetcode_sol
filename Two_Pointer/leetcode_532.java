package Two_Pointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leetcode_532 {
    public static void main(String[] args) {
        int [] arr = {1,2,4,4,3,3,0,9,2,3};

        String s = "ba";
        StringBuilder sb = new StringBuilder(s);
        System.out.println();
        System.out.println(allPair(arr,3));
    }
    public static int allPair(int[]arr, int k){
        int n = arr.length;
        if(n==1){
            return 0;
        }

        Arrays.sort(arr);
        Map<String,Integer> mp = new HashMap<>();

        for(int i = 0;i<n-1;i++){

            for(int j = i+1;j<n;j++){
                String pair = arr[i] + "";
                if(Math.abs(arr[i]-arr[j])==k){
                    pair += arr[j];
                    if(!mp.containsKey(pair)){
                        mp.put(pair,i);
                    }
                }
            }
        }
        return mp.size();
    }
}
