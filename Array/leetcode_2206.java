package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leetcode_2206 {
    public static void main(String[] args) {
        int[] arr= {3,2,3,2,2,2};
        System.out.println(isUsingMap(arr));

    }
    public static boolean isPossible(int []arr){
        int res = 0;
        if(arr.length%2 != 0){
            return false;
        }

        Arrays.sort(arr);
        for(int num: arr){
            res ^= num;
            if (res !=0 && res != num){
                return false;
            }
        }
        return res == 0;
    }

    public static boolean isUsingMap(int[] arr){
        int n = arr.length;
        Map<Integer,Integer> mp = new HashMap<>();
        for (int j : arr) {
            mp.put(j, mp.getOrDefault(j, 0) + 1);
        }
        for (Map.Entry<Integer,Integer> entry : mp.entrySet()){
            if (entry.getValue()%2 != 0){
                return false;
            }
        }
        return true;
    }
}
