package Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class leetcode_1353 {
    public static void main(String[] args) {
        int[][]arr ={{1,2},{2,3},{3,4}};
        System.out.println(eventCount(arr));
    }
    public static int eventCount(int[][] arr){
        int n = arr.length;
        Arrays.sort(arr,(a,b)-> Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        int ans = 0;
        int i = 0;
        int currDay = arr[0][0];

        while (!pq.isEmpty() || i<n){
            if (pq.isEmpty()){
                currDay= arr[i][0];
            }
            while (i<n&&currDay==arr[i][0]){
                pq.offer(arr[i][1]);
                i++;
            }

            if (!pq.isEmpty()){
                pq.poll();
                ans++;
            }
            currDay++;
            while (!pq.isEmpty() && pq.peek()<currDay){
                pq.poll();
            }
        }
        return ans;
    }
}
