package Prefix_Sum;

import java.util.HashMap;
import java.util.Map;

public class leetcode_523 {
    public static void main(String[] args) {
        int[]arr = {23,2,6,4,7};
        System.out.println(isGood(arr,6));
    }
    public static boolean isGood(int[]arr,int k){
        int n = arr.length;
        if(n<2){
            return false;
        }
        if(k==1){
            return true;
        }

        Map<Integer,Integer> mp = new HashMap<>();
        int sum = 0;
        mp.put(0,-1);
        for(int i =0;i<n;i++){
            sum += arr[i];
            int multiple = sum%k;

            if(mp.containsKey(multiple)){
                if(i-mp.get(multiple)>=2){
                    return true;
                }
            }
            else{
                mp.put(multiple,i);
            }
        }
        return false;
    }
}
