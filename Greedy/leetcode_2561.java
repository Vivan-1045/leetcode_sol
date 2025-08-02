package Greedy;

import java.util.*;

public class leetcode_2561 {
    public static void main(String[] args) {
        int[] bas1 = {4,2,2,2};
        int[] bas2 = {1,4,1,2};
        System.out.println(getMinCost(bas1,bas2));
    }
    public static long getMinCost(int[] bas1, int[] bas2){
        Map<Integer,Integer> mp = new HashMap<>();
        long ans = 0;
        List<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int num : bas1){
            mp.put(num,mp.getOrDefault(num,0)+1);
            min = Math.min(min,num);
        }

        for(int num : bas2){
            mp.put(num,mp.getOrDefault(num,0)-1);
            min = Math.min(min,num);
        }

        for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
            if(entry.getValue()%2 != 0){
                return -1;
            }

            for(int i = 0;i<Math.abs(entry.getValue())/2;i++){
                list.add(entry.getKey());
            }

        }

        Collections.sort(list);

        for(int i = 0;i<list.size()/2;i++){
            ans += Math.min(list.get(i),min*2);
        }

        return ans;
    }
}
