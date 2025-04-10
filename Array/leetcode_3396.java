package Array;

import java.util.HashMap;
import java.util.Map;

public class leetcode_3396 {
    public static void main(String[] args) {
        int []arr= {1, 2, 3, 4, 4, 4, 4, 4, 4};
        Map<Integer,Integer> mp =  new HashMap<>();
        int i =0;
        int count = 0;
        boolean a = isDuplicate(getFreq(arr,i,mp));
        while (a){
            count +=1;
            mp.clear();
            a = isDuplicate(getFreq(arr,i+=3,mp));
        }

        System.out.println(count);
    }
    public static Map<Integer,Integer> getFreq(int[] arr,int s,Map<Integer,Integer>mp){
        for(int i = s;i<arr.length;i++){
            mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
        }
        return mp;
    }
    public static boolean isDuplicate(Map<Integer,Integer> mp){
        for (Map.Entry<Integer,Integer> entry : mp.entrySet()){
            if (entry.getValue()>=2){
                return true;
            }
        }
        return false;
    }
}
