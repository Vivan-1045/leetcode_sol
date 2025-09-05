package Heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class leetcode_2679 {
    public static void main(String[] args) {

    }
    public static int matrixSum1(int[][] arr){
        int sum = 0;

        int n = arr.length;
        int m = arr[0].length;
        int j = m-1;
        while(m-->0){
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for(int i = 0;i<n;i++){
                Arrays.sort(arr[i]);
                pq.offer(arr[i][j]);
                arr[i][j] = 0;
            }
            sum += pq.poll();
            pq.clear();
        }

        return sum;
    }
}
