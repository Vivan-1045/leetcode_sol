package Sliding_window;

import java.util.HashMap;
import java.util.Map;

public class leetcode_904 {
    public static void main(String[] args) {
        int[] arr = {0,0,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(fruitCount(arr));
    }
    public static int fruitCount(int[] arr){
        int res = 0;
        int n = arr.length;
        int j = 0;
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i = 0;i<n;i++){
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
            while(mp.size()>2) {
                mp.put(arr[j], mp.get(arr[j])-1);
                if (mp.get(arr[j])==0) {
                    mp.remove(arr[j]);
                }
                j++;
            }

            res = Math.max(res,i-j+1);
        }

        return res;
    }
}
