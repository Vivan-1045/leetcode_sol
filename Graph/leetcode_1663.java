package Graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class leetcode_1663 {
    class Pair{
        int diff;
        int x;
        int y;
        Pair(int wt, int a, int b){
            this.diff=wt;
            this.x=a;
            this.y=b;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        return minEffort(heights);
    }

    int minEffort(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;

        int[][] dist = new int[n][m];

        for(int a[] : dist){
            Arrays.fill(a,Integer.MAX_VALUE);
        }

        dist[0][0] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.diff - b.diff);
        pq.offer(new Pair(0,0,0));

        int [][] dir = {{0,1},{1,0},{-1,0},{0,-1}};

        while(!pq.isEmpty()){
            int diff = pq.peek().diff;
            int x = pq.peek().x;
            int y = pq.peek().y;
            pq.poll();

            if(x==n-1 && y == m-1){
                return diff;
            }

            for(int d[] : dir){
                int nx = x + d[0];
                int ny = y + d[1];

                if(nx>=0 && ny>=0 && nx<n && ny<m){
                    int nEffort = Math.max(Math.abs(arr[x][y]-arr[nx][ny]),diff);
                    if(dist[nx][ny]>nEffort){
                        dist[nx][ny] = nEffort;
                        pq.offer(new Pair(nEffort,nx,ny));
                    }
                }
            }
        }

        return 0;
    }
}
