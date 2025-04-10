package Array;

import java.util.HashMap;
import java.util.Map;

public class leetcode_3375 {
    public static void main(String[] args) {
        int [] arr = {2,1,88,88,5,6,3};
        int k = 1;
        System.out.println(minOpr(arr,k));
    }
    public static int minOpr(int[] arr,int k){
        int n = arr.length;
        int count = 0;
        Map<Integer,Integer> mp = new HashMap<>();
        for (int i =0;i<n;i++){
            mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
        }

        for (Map.Entry<Integer,Integer> entry : mp.entrySet()){
            if (entry.getKey()<k){
                return -1;
            }
            if (entry.getKey()>k){
                count++;
            }
            if (entry.getKey()==k && mp.size()==1){
                return 0;
            }
        }
        return count;
    }
}
