package Contests;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class biweekly_160 {
    public static void main(String[] args) {
        int[][] arr = {{1,2}};
        System.out.println(minimumCost(1,2,arr));
    }
    public static String conversion(int n){
        String s = Integer.toHexString(n*n).toUpperCase();
        String t = Integer.toString(n*n*n,36).toUpperCase();
        return s+t;
    }

    public static long minimumCost(int m, int n, int[][] waitCost) {
        long[][][] visited = new long[m][n][2];
        for (long[][] row : visited) {
            for (long[] col : row) {
                Arrays.fill(col, Long.MAX_VALUE);
            }
        }
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));

        int startCost = 1;
        pq.offer(new long[]{startCost, 0, 0, 1});
        visited[0][0][1] = startCost;

        int[][] direct = {{1, 0}, {0, 1}};

        while (!pq.isEmpty()) {
            long[] currState = pq.poll();
            long cost = currState[0];
            int row = (int)currState[1];
            int col =(int) currState[2];
            int evenOrOdd = (int)currState[3];

            if (row == m - 1 && col == n - 1)
                return cost;

            if (cost > visited[row][col][evenOrOdd])
                continue;

            if (evenOrOdd == 1) {
                for (int[] dir : direct) {
                    int nRow = row + dir[0];
                    int nCol = col + dir[1];
                    if (nRow < m && nCol < n) {
                        int cellCost = (nRow + 1) * (nCol + 1);
                        if (cost+cellCost < visited[nRow][nCol][0]) {
                            visited[nRow][nCol][0] = cost+cellCost;
                            pq.offer(new long[]{cost+cellCost, nRow, nCol, 0});
                        }
                    }
                }
            } else {
                int wait = waitCost[row][col];
                if (cost+wait < visited[row][col][1]) {
                    visited[row][col][1] = cost+wait;
                    pq.offer(new long[]{cost+wait, row, col, 1});
                }
            }
        }

        return -1;
    }
}
