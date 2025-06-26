package Two_Pointer;

import java.util.HashMap;
import java.util.Map;

public class leetcode_80 {
    public static void main(String[] args) {
       int[] arr = {0,0,1,1,1,1,2,3,3};
        System.out.println(removedElement(arr));
    }
    public static int removedElement(int[] arr){
        Map<Integer,Integer> mp = new HashMap<>();
        for (int i =0;i<arr.length;i++){
            mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
        }

        int total = 0;
        for (int freq : mp.values()){
            if (freq>2){
                total += freq-2;
            }
        }
        return arr.length-total;
    }
}
