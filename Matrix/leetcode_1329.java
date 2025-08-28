package Matrix;

import java.util.Collections;
import java.util.PriorityQueue;

public class leetcode_1329 {
    public static void main(String[] args) {

    }
    public static int[][] sortedMatrix(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        if(n==1){
            return new int[][]{arr[0]};
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0;i<n;i++){
            int j = 0;
            int k = i;

            while(k<n && j<m){
                pq.offer(arr[k][j]);
                k++;
                j++;
            }
            k--;
            j--;

            while(k>=i && j>=0){
                arr[k][j] = pq.poll();
                k--;
                j--;
            }
            pq.clear();
        }

        for(int j = 1;j<m;j++){
            int i = 0;
            int k = j;

            while(k<m && i < n){
                pq.offer(arr[i][k]);
                k++;
                i++;
            }
            k--;
            i--;

            while(k>=j && i>=0){
                arr[i][k] = pq.poll();
                k--;
                i--;
            }
            pq.clear();
        }

        return arr;
    }
}
