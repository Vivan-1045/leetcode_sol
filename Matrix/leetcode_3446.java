package Matrix;

import java.util.Collections;
import java.util.PriorityQueue;

public class leetcode_3446 {
    public static void main(String[] args) {

    }

    public static int[][] sortedMatrix(int[][] arr){
        int n = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0;i<n;i++){
            int j = 0;
            int k = i;

            while(k<n){
                pq.offer(arr[k][j]);
                k++;
                j++;
            }
            k--;
            j--;

            while(k>=i){
                arr[k][j] = pq.poll();
                k--;
                j--;
            }
            pq.clear();
        }

        for(int j = 1;j<n;j++){
            int i = 0;
            int k = j;

            while(k<n){
                pq1.offer(arr[i][k]);
                k++;
                i++;
            }
            k--;
            i--;

            while(k>=j){
                arr[i][k] = pq1.poll();
                k--;
                i--;
            }
            pq1.clear();
        }

        return arr;
    }
}
