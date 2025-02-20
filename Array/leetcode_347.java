package Array;

import javax.swing.*;
import java.util.*;

public class leetcode_347 {
    public static void main(String[] args) {
        int [] arr = {1,2};
        int k = 2;
        System.out.println(Arrays.toString(mostFrequent(arr,k)));
    }
    public static int[]  mostFrequent(int[] arr,int k){
        int[] ans = new int[k];
        Map<Integer,Integer> mp = new HashMap<>();


        for (int j : arr) {
            mp.put(j, mp.getOrDefault(j, 0) + 1);
        }

        // Max heap
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        // Add all freq and value in the max heap
        pq.addAll(mp.entrySet());


        int i = 0;
        while (i<k && !pq.isEmpty()){
            ans[i] = pq.poll().getKey();
            i++;
        }

        return ans;
    }
}
