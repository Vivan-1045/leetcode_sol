package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode_2780 {
    public static void main(String[] args) {
        int[] arr = {1,2,1,1};
        List<Integer> list =  new ArrayList<>();
        for (int i = 0;i<arr.length;i++){
            list.add(arr[i]);
        }
        System.out.println(splitIndex(list));
    }
    public static int splitIndex(List<Integer> list){
        int n = list.size();
        Map<Integer,Integer> mp = new HashMap<>();
        for (int i = 0;i<n;i++){
            mp.put(list.get(i),mp.getOrDefault(list.get(i),0)+1);
        }


        int maxFreq = 0;
        int ele = 0;
        for (Map.Entry<Integer,Integer> enty : mp.entrySet()){
            if (enty.getValue()>maxFreq){
                maxFreq = enty.getValue();
                ele = enty.getKey();
            }
        }


        int doMinant = 0;
        for (int i = 0;i<n;i++){
            if (list.get(i)==ele){
                doMinant += 1;
                if (i+1-doMinant<doMinant && maxFreq-doMinant>n-i-1-(maxFreq-doMinant)){
                    return i;
                }

            }
        }
        return -1;
    }
}
