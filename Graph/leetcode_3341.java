package Graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class leetcode_3341 {

    public static int [][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) {
        int[][] arr = {{0,0,0},{0,0,0},{0,0,0}};
        System.out.println(minTimeToHome(arr));
    }
    public static int minTimeToHome(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;

        int [][]res = new int[n][m];
        for (int [] row : res){
            Arrays.fill(row,Integer.MAX_VALUE);
        }


        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        res[0][0] = 0;
        pq.offer(new int[]{0,0,0});


        while (!pq.isEmpty()){
            int [] curr = pq.poll();
            int currTime = curr[0];
            int i = curr[1];
            int j = curr[2];

            if (i== n-1 && j==m-1){
                return currTime;
            }

            for (int[] dir : direction) {
                int i_ = i + dir[0];
                int j_ = j + dir[1];

                if (i_ >= 0 && i_ < n && j_ >= 0 && j_ < m) {
                    int wait = Math.max(arr[i_][j_] - currTime, 0);
                    int arrTime = currTime + wait + 1;

                    if (res[i_][j_] > arrTime) {
                        res[i_][j_] = arrTime;
                        pq.offer(new int[]{arrTime, i_, j_});
                    }
                }
            }
        }
        return -1;
    }
}
