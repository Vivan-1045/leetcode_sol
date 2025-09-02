package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class leetcode_215 {
    public static void main(String[] args) {

    }
    public static int findElement(int[]arr,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int ele : arr){
            pq.offer(ele);
        }

        int ans = -1;
        while(k-->0){
            ans = pq.poll();
        }

        return ans;
    }
}
