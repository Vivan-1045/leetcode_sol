package Array;

import java.util.HashMap;
import java.util.Map;

public class leetcode_2537 {
    public static void main(String[] args) {
       int []arr=  {1,1,1,1,1};
       int k =10;
       System.out.println(goodSubarrayCount(arr,k));
    }
    public static long goodSubarrayCount(int[]arr,int k){
        int n = arr.length;
        long pair = 0;
        long res = 0;
        Map<Integer,Integer> mp = new HashMap<>();



        int i = 0;
        int j =0;
        while (i<n){
            pair += mp.getOrDefault(arr[i],0);
            mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);

            while (pair>= k){
                res += n-i;
                mp.put(arr[j],mp.get(arr[j])-1);
                pair -= mp.get(arr[j]);
                j++;
            }
            i++;
        }
        return res;
    }
}

